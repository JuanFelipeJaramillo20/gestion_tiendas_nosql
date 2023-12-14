package com.gestion_tiendas_nosql.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion_tiendas_nosql.Entities.Client;
import com.gestion_tiendas_nosql.Entities.Product;
import com.gestion_tiendas_nosql.Entities.Store;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    @JsonProperty
    private Date orderDate;
    @JsonProperty
    private Integer status;
    @JsonProperty
    private String deliveryAddress;
    @JsonProperty
    private Client client;
    @JsonProperty
    private List<Product> products;
    @JsonProperty
    private Store store;
}
