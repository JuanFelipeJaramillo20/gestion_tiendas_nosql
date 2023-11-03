package com.gestion_tiendas_nosql.Repositories;

import com.gestion_tiendas_nosql.Entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
}
