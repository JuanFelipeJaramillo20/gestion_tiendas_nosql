package com.gestion_tiendas_nosql.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion_tiendas_nosql.Entities.Order;
import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {

    @JsonProperty
    private String fullName;
    @JsonProperty
    private String address;
    @JsonProperty
    private String phoneNumber;
    @JsonProperty
    private List<Order> orderHistory;

}
