package com.softserve.academy.module9;

public class CastomException extends RuntimeException {
    public CastomException(String message) {
        super(message);
    }

    public CastomException() {
        super();
    }

    public CastomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CastomException(Throwable cause) {
        super(cause);
    }
}
