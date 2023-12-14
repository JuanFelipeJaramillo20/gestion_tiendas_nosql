package com.gestion_tiendas_nosql.Exceptions;

public class RefundNotFoundException extends RuntimeException{
    public  RefundNotFoundException(String id){
        super("Refund not found with id: " + id);
    }
}
