package valatava.lab.warehouse.service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valatava.lab.warehouse.exeption.UserNotActivatedException;
import valatava.lab.warehouse.model.User;
import valatava.lab.warehouse.repository.UserRepository;

/**
 * Authenticate a user from the database.
 *
 * @author Yuriy Govorushkin
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) {
        String userLogin = login.toLowerCase(Locale.ENGLISH);
        return userRepository.findByLogin(userLogin)
                .map(user -> createSpringSecurityUser(userLogin, user))
                .orElseThrow(() -> new UsernameNotFoundException("User " + userLogin + " was not found in the database"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String userLogin, User user) {
        if (!user.isActivated()) {
            throw new UserNotActivatedException("User " + userLogin + " was not activated");
        }
        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(),
                grantedAuthorities);
    }
}
