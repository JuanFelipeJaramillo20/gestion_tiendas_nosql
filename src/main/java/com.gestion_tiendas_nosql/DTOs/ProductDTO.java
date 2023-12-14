package com.gestion_tiendas_nosql.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion_tiendas_nosql.Entities.Provider;
import com.gestion_tiendas_nosql.Entities.Store;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductDTO {

    @JsonProperty
    private String name;
    @JsonProperty
    private String description;
    @JsonProperty
    private String category;
    @JsonProperty
    private Double unitPrice;
    @JsonProperty
    private Date expirationDate;
    @JsonProperty
    private List<Provider> providers;
    @JsonProperty
    private List<Store> stores;

    @JsonProperty
    private String serialNumber;
}
