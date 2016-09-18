package com.intertec.exceptions;

public class UserNameExistingException extends Exception{

    public UserNameExistingException() {
        super("userName already exists");
    }
    
}
