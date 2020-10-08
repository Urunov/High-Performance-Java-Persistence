package com.urunov.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvalidArgumentException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public InvalidArgumentException(String message, String invalidArgument) {
        super(message);
        extensions.put("invalidArgument", invalidArgument);
    }

    public InvalidArgumentException(String message, Integer values){
        super(message);
        extensions.put("invalidArgument", values);
    }
    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }
}


