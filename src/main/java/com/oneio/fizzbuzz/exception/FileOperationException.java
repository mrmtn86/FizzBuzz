package com.oneio.fizzbuzz.exception;

import java.util.Collections;
import java.util.List;

public class FileOperationException extends Exception {
    public static final String INVALID_REQUEST = "Data operation error";

    private final List<String> errors;

    public FileOperationException(String error) {
        this(INVALID_REQUEST, error);
    }

    public FileOperationException(String message, String error) {
        this(message, Collections.singletonList(error));
    }

    public FileOperationException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
