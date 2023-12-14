package com.gestion_tiendas_nosql.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Clients")
public class Client {

    @Id
    private String id;
    private String fullName;
    private String address;
    private String phoneNumber;

    private List<Order> orderHistory;
}
