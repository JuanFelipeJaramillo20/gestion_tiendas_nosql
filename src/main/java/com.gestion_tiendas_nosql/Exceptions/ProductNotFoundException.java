package com.gestion_tiendas_nosql.Exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String id){
        super("Product not found with id:" + id);
    }
}
