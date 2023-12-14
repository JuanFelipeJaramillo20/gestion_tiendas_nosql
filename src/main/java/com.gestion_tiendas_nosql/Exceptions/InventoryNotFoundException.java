package com.gestion_tiendas_nosql.Exceptions;

public class InventoryNotFoundException extends RuntimeException{
    public InventoryNotFoundException(String id){
        super("Inventory not found with id:" + id);
    }
}
