package ak.programming.task.exception;

public class DeckIsEmptyError extends Error {
    public DeckIsEmptyError(String message, Throwable cause) {
        super(message, cause);
    }
}
