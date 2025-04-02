package com.ivoyant.CRUDinRESTAPI.exception;
//custom exception class which is throwed when employee of an id doesnot exists
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
