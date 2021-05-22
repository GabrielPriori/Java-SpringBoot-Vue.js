package org.bootcamp.mycash.exception;

public class UsuarioExcepiton extends RuntimeException{
    public UsuarioExcepiton() {
    }

    public UsuarioExcepiton(String message) {
        super(message);
    }

    public UsuarioExcepiton(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioExcepiton(Throwable cause) {
        super(cause);
    }

    public UsuarioExcepiton(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
