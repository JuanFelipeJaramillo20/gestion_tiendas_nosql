package com.gestion_tiendas_nosql.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion_tiendas_nosql.Entities.Product;
import com.gestion_tiendas_nosql.Entities.Store;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReportDTO {

    @JsonProperty
    private Date date;
    @JsonProperty
    private List<Product> productList;
    @JsonProperty
    private Store store;
}
