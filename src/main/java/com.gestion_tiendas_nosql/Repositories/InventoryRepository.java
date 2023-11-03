package com.gestion_tiendas_nosql.Repositories;

import com.gestion_tiendas_nosql.Entities.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
}
