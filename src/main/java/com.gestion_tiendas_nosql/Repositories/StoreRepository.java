package com.gestion_tiendas_nosql.Repositories;

import com.gestion_tiendas_nosql.Entities.Product;
import com.gestion_tiendas_nosql.Entities.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreRepository extends MongoRepository<Store, String> {
}
