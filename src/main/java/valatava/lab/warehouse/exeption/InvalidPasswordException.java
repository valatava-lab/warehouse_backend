package valatava.lab.warehouse.exeption;

/**
 * @author Yuriy Govorushkin
 */
public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super("Incorrect password");
    }
}
