package com.ivoyant.CRUDinRESTAPI.exception;

public class RequestBodyShouldNotHavePrimaryKey extends RuntimeException{
    public RequestBodyShouldNotHavePrimaryKey(String message){
        super(message);
    }
}
