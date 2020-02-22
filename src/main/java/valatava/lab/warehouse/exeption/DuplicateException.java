package valatava.lab.warehouse.exeption;

/**
 * @author Yuriy Govorushkin
 */
public class DuplicateException extends Exception{

    private static String message = "Создание дубликатов запрещено! ";

    public DuplicateException() {
        super(message);
    }
}
