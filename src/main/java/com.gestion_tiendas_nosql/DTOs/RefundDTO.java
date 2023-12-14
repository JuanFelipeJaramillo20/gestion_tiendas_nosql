package com.gestion_tiendas_nosql.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion_tiendas_nosql.Entities.Client;
import com.gestion_tiendas_nosql.Entities.Order;
import com.gestion_tiendas_nosql.Entities.Product;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RefundDTO {

    @JsonProperty
    private Date date;
    @JsonProperty
    private Order order;
    @JsonProperty
    private Client client;
    @JsonProperty
    private List<Product> returnedProducts;
    @JsonProperty
    private String causeOfReturn;
}
