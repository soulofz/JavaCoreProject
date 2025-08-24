package JavaCore_Project.Exceptions;

public class InvalidAmountException extends RuntimeException {
  public InvalidAmountException() {
    super("Некорректная сумма.");
  }

  public InvalidAmountException(String message) {
    super(message);
  }
}
