package com.example.employeepayroll.exception;
/*
*ResourceNotFoundException class handle error thrown for resource not found
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
