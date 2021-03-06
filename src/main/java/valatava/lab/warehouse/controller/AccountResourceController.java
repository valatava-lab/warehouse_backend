package valatava.lab.warehouse.controller;

import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import valatava.lab.warehouse.exeption.AccountResourceException;
import valatava.lab.warehouse.exeption.InvalidPasswordException;
import valatava.lab.warehouse.model.User;
import valatava.lab.warehouse.service.MailService;
import valatava.lab.warehouse.service.UserService;
import valatava.lab.warehouse.service.vm.UserVM;

/**
 * REST controller for managing the current user's account.
 *
 * @author Yuriy Govorushkin
 */
@RestController
@RequestMapping("/api")
public class AccountResourceController {

    private final UserService userService;
    private final MailService mailService;

    public AccountResourceController(UserService userService, MailService mailService) {
        this.userService = userService;
        this.mailService = mailService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@RequestBody UserVM userVM) {
        if (!checkPasswordLength(userVM.getPassword())) {
            throw new InvalidPasswordException();
        }
        User user = userService.registrationUser(userVM, userVM.getPassword());
        mailService.sendActivationEmail(user);
    }

    @GetMapping("/activate")
    public void activateAccount(@RequestParam String key) {
        Optional<User> user = userService.activateRegistration(key);
        if (!user.isPresent()) {
            throw new AccountResourceException();
        }
    }

    private static boolean checkPasswordLength(String password) {
        return !StringUtils.isEmpty(password) &&
                password.length() >= UserVM.PASSWORD_MIN_LENGTH &&
                password.length() <= UserVM.PASSWORD_MAX_LENGTH;
    }
}
