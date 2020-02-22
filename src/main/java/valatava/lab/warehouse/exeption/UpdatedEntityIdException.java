package valatava.lab.warehouse.exeption;

/**
 * @author Yuriy Govorushkin
 */
public class UpdatedEntityIdException extends Exception {

    private static String message = "Обновляемый объект не может иметь пустое поле Id";

    public UpdatedEntityIdException() {
        super(message);
    }
}
