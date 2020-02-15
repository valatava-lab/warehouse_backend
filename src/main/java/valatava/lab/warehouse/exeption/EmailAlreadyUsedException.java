package valatava.lab.warehouse.exeption;

public class EmailAlreadyUsedException extends RuntimeException {

    public EmailAlreadyUsedException() {
        super("Email name already used!");
    }
}
