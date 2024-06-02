package com.mastertheboss.jaxrs;

public class UserAccountException extends RuntimeException{

    public UserAccountException() {
        super();
    }
    public UserAccountException(String exc) {
        super(exc);
    }

}
