package com.udacity.vehicles.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Declares methods to return errors and other messages from the API.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private final String message;
    private final List<String> errors;

    public ApiError(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getErrors() {
        return this.errors;
    }

}