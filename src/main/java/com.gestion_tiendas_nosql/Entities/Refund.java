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
@Document(collection = "Refunds")
public class Refund {

    @Id
    private String id;
    private Date date;
    private Order order;
    private Client client;
    private List<Product> returnedProducts;
    private String causeOfReturn;
}
