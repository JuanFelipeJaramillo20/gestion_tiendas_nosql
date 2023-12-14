package com.gestion_tiendas_nosql.Exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String id){
        super("Order not found with id:" + id);
    }
}
