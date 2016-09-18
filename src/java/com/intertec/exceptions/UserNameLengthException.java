package com.intertec.exceptions;

public class UserNameLengthException extends Exception{

    public UserNameLengthException() {
        super("userName can not have less than 6 characters long");
    }
    
}
