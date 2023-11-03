package com.gestion_tiendas_nosql.Repositories;

import com.gestion_tiendas_nosql.Entities.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {
}
