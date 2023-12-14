package com.gestion_tiendas_nosql.Exceptions;

public class StoreNotFoundException extends RuntimeException{
    public StoreNotFoundException(String id){
        super("Store not found with id: " + id);
    }
}
