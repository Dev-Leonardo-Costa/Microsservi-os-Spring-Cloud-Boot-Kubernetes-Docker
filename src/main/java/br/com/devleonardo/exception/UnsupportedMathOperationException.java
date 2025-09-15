package br.com.devleonardo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

    public static final String NUMERIC_VALUE = "Please set a numeric value!";

    public UnsupportedMathOperationException(String message) {
        super(message);
    }
}
