package com.gestion_tiendas_nosql.Repositories;

import com.gestion_tiendas_nosql.Entities.Refund;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RefundRepository extends MongoRepository<Refund, String> {
}
