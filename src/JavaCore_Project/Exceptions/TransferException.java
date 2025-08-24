package JavaCore_Project.Exceptions;

public class TransferException extends RuntimeException {
    public TransferException() {
        super("Ошибка перевода.");
    }

    public TransferException(String message) {
        super(message);
    }
}
