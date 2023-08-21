package org.bfsi.bureau.exception;

public class ExceededAmountException extends RuntimeException{

    public ExceededAmountException(String message) {
        super(message);
    }
}
