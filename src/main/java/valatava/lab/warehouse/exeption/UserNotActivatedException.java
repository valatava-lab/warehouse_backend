package valatava.lab.warehouse.exeption;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Yuriy Govorushkin
 */
public class UserNotActivatedException extends AuthenticationException {

    public UserNotActivatedException(String message) {
        super(message);
    }

    public UserNotActivatedException(String message, Throwable t) {
        super(message, t);
    }
}
