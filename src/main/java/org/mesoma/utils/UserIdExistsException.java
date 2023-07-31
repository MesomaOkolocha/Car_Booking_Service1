package org.mesoma.utils;

public class UserIdExistsException extends RuntimeException{
    public UserIdExistsException(String message) {
        super(message);
    }
}
