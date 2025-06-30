package com.mayur.bookmyshow.exceptions;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String userNotFound) {
        super(userNotFound);
    }
}
