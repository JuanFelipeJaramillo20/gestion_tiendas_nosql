package com.gestion_tiendas_nosql.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion_tiendas_nosql.Entities.Product;
import com.gestion_tiendas_nosql.Entities.Report;
import lombok.Data;

import java.util.List;

@Data
public class InventoryDTO {

    @JsonProperty
    private List<Report> reportList;
    @JsonProperty
    private List<Product> productList;
}
