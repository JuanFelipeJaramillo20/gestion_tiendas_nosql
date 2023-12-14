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
@Document(collection = "Orders")
public class Order {

    @Id
    private String id;
    private Date orderDate;
    private Integer status;
    private String deliveryAddress;
    private Client client;
    private List<Product> products;

    private Store store;
}
