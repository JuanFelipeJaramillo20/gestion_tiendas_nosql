package com.gestion_tiendas_nosql.Exceptions;

public class ProviderNotFoundException extends RuntimeException{
    public ProviderNotFoundException(String id){
        super("Provider not found with id " + id);
    }
}
