package com.gestion_tiendas_nosql.Repositories;

import com.gestion_tiendas_nosql.Entities.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String> {
}
