package com.eduardo.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    
    public ObjectNotFoundException(Object id){
        super("Objeto não encontrado: " + id);
    }
}
