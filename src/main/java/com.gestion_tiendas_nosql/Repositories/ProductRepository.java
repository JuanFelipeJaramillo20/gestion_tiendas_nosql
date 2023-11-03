package com.gestion_tiendas_nosql.Repositories;

import com.gestion_tiendas_nosql.Entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
