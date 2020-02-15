package valatava.lab.warehouse.exeption;

/**
 * @author Yuriy Govorushkin
 */
public class UsernameAlreadyUsedException extends RuntimeException {

    public UsernameAlreadyUsedException() {
        super("Login name already used!");
    }
}
