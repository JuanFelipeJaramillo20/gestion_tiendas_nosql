package com.gestion_tiendas_nosql.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion_tiendas_nosql.Entities.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProviderDTO {

    @JsonProperty
    private String name;
    @JsonProperty
    private String address;
    @JsonProperty
    private String contact;
    @JsonProperty
    private List<Product> suppliedProducts;
}
