package com.gestion_tiendas_nosql.Services;

import com.gestion_tiendas_nosql.Repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;
}
