package com.gestion_tiendas_nosql.Repositories;

import com.gestion_tiendas_nosql.Entities.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProviderRepository extends MongoRepository<Provider, String> {
}
