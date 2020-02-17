package valatava.lab.warehouse.exeption;

/**
 * @author Yuriy Govorushkin
 */
public class EmailAlreadyUsedException extends RuntimeException {

    public EmailAlreadyUsedException() {
        super("Email name already used!");
    }
}
