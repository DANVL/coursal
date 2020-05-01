package com.lyash.tokensecurity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;


@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ApplicationGlobalException extends RuntimeException {

    public ApplicationGlobalException() {
    }

    public ApplicationGlobalException(String message) {
        super(message);
    }

    public ApplicationGlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getHttpStatus() {
        return Optional.ofNullable(getClass().getAnnotation(ResponseStatus.class))
                .orElseGet(() -> com.lyash.tokensecurity
                        .exceptions.ApplicationGlobalException.class.getAnnotation(ResponseStatus.class))
                .value();
    }
}
