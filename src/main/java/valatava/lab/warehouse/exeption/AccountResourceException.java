package valatava.lab.warehouse.exeption;

public class AccountResourceException extends RuntimeException {

    public AccountResourceException() {
        super("No user was found for this activation key");
    }
}
