package me.skypro.Homework_2._4.exception;

public class ElementNotFoundExcption extends RuntimeException {
    public ElementNotFoundExcption(String message) {
        super(message);
    }

    public ElementNotFoundExcption() {
    }

    public ElementNotFoundExcption(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementNotFoundExcption(Throwable cause) {
        super(cause);
    }

    public ElementNotFoundExcption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
