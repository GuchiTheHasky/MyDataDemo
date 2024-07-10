package the.husky.demo_data.exception;

public class ProcessException extends RuntimeException {
    private static final String MESSAGE = "Process was stopped on page by administrator.";

    public ProcessException() {
        super(MESSAGE);
    }
}
