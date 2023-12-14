package com.gestion_tiendas_nosql.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Products")
public class Product {
    @Id
    private String id;
    private String name;

    private String serialNumber;
    private String description;
    private String category;
    private Double unitPrice;
    private Date expirationDate;
    private List<Provider> providers;

    private List<Store> stores;
}
