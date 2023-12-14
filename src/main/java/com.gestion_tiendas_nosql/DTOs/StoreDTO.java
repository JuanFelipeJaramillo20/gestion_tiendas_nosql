package com.gestion_tiendas_nosql.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion_tiendas_nosql.Entities.Product;
import lombok.Data;

import java.util.List;

@Data
public class StoreDTO {

    @JsonProperty
    private String name;
    @JsonProperty
    private String address;
    @JsonProperty
    private String city;
    @JsonProperty
    private String zipCode;
    @JsonProperty
    private Integer storageCapacity;
    @JsonProperty
    private String schedule;
    @JsonProperty
    private List<Product> products;
}
