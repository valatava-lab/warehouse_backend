package valatava.lab.warehouse.exeption;

/**
 * @author Yuriy Govorushkin
 */
public class CreatedEntityIdException extends Exception {

    private static String message = "Создаваемый объект не может иметь заполненное поле Id";

    public CreatedEntityIdException() {
        super(message);
    }
}
