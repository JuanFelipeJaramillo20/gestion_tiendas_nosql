package com.gestion_tiendas_nosql.Exceptions;

public class ReportNotFoundException extends RuntimeException{
    public ReportNotFoundException(String id){
        super("Report not found with id: " + id);
    }
}
