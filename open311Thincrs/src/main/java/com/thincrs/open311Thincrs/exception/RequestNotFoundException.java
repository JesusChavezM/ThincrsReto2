package com.thincrs.open311Thincrs.exception;

public class RequestNotFoundException extends RuntimeException{
    public RequestNotFoundException(long id){
        super("No se puede encontrar una solicitud perteneciente a esta id: "+id);
    }
}
