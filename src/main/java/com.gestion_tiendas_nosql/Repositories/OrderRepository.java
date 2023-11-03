package com.gestion_tiendas_nosql.Repositories;

import com.gestion_tiendas_nosql.Entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
