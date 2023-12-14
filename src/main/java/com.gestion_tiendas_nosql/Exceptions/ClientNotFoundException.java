package com.gestion_tiendas_nosql.Exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String clientId) {
        super("Client not found with ID: " + clientId);
    }
}
