package com.thincrs.open311Thincrs.exception;

public class ServicesNotFoundException extends RuntimeException{
    public ServicesNotFoundException(long id){
        super("No se puede encontrar un servicio correspondiente a esta id: "+id);
    }
}
