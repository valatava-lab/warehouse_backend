package valatava.lab.warehouse.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import valatava.lab.warehouse.exeption.EmailAlreadyUsedException;
import valatava.lab.warehouse.exeption.UsernameAlreadyUsedException;
import valatava.lab.warehouse.model.Authority;
import valatava.lab.warehouse.model.User;
import valatava.lab.warehouse.repository.AuthorityRepository;
import valatava.lab.warehouse.repository.UserRepository;
import valatava.lab.warehouse.security.AuthoritiesConstants;
import valatava.lab.warehouse.service.dto.UserDTO;
import valatava.lab.warehouse.service.util.RandomUtil;

/**
 * Service class for managing users.
 *
 * @author Yuriy Govorushkin
 */
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registrationUser(UserDTO userDTO, String password) {
        userRepository.findByLogin(userDTO.getLogin().toLowerCase()).ifPresent(user -> {
            if (user.isActivated()) {
                throw new UsernameAlreadyUsedException();
            }
        });
        userRepository.findByEmail(userDTO.getEmail()).ifPresent(user -> {
            if (user.isActivated()) {
                throw new EmailAlreadyUsedException();
            }
        });
        String encryptedPassword = passwordEncoder.encode(password);
        User newUser = new User();
        newUser.setLogin(userDTO.getLogin().toLowerCase());
        newUser.setPassword(encryptedPassword);
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setEmail(userDTO.getEmail().toLowerCase());
        newUser.setActivated(false);
        newUser.setActivationKey(RandomUtil.generateActivationKey());
        Set<Authority> authorities = new HashSet<>();
        authorityRepository.findByName(AuthoritiesConstants.USER).ifPresent(authorities::add);
        newUser.setAuthorities(authorities);
        userRepository.save(newUser);
        return newUser;
    }

    public Optional<User> activateRegistration(@RequestParam(value = "key") String key) {
        return userRepository.findByActivationKey(key).map(user -> {
            user.setActivationKey(null);
            user.setActivated(true);
            return user;
        });
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<String> getAuthorities() {
        return authorityRepository.findAll()
                .stream()
                .map(Authority::getName)
                .collect(Collectors.toList());
    }

    public Optional<User> findUser(String login) {
        return userRepository.findByLogin(login);
    }
}
