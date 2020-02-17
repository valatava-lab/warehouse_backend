package valatava.lab.warehouse.exeption;

/**
 * @author Yuriy Govorushkin
 */
public class AccountResourceException extends RuntimeException {

    public AccountResourceException() {
        super("No user was found for this activation key");
    }
}
