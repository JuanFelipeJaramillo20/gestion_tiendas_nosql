package com.gestion_tiendas_nosql.Services;

import com.gestion_tiendas_nosql.DTOs.StoreDTO;
import com.gestion_tiendas_nosql.Exceptions.StoreNotFoundException;
import com.gestion_tiendas_nosql.Entities.Store;
import com.gestion_tiendas_nosql.Repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getStores(){ return  storeRepository.findAll(); }

    public Store getStoreById(String id){
        Optional<Store> store = storeRepository.findById(id);
        if(store.isPresent()){
            return store.get();
        }else{
            throw new StoreNotFoundException(id);
        }
    }

    public Store createStore(StoreDTO storeDTO){
        Store store = Store
                .builder()
                .name(storeDTO.getName())
                .address(storeDTO.getAddress())
                .city(storeDTO.getCity())
                .zipCode(storeDTO.getZipCode())
                .storageCapacity(storeDTO.getStorageCapacity())
                .schedule(storeDTO.getSchedule())
                .products(storeDTO.getProducts())
                .build();

        return storeRepository.save(store);
    }

    public Store updateStore(String id, StoreDTO storeDTO){
        Optional<Store> optionalStore = storeRepository.findById(id);
        if(optionalStore.isPresent()){
            Store existingStore = optionalStore.get();
            existingStore.setName(storeDTO.getName());
            existingStore.setAddress(storeDTO.getAddress());
            existingStore.setCity(storeDTO.getCity());
            existingStore.setZipCode(storeDTO.getZipCode());
            existingStore.setSchedule(storeDTO.getSchedule());
            existingStore.setStorageCapacity(storeDTO.getStorageCapacity());
            existingStore.setProducts(storeDTO.getProducts());
            return storeRepository.save(existingStore);
        }else{
            throw new StoreNotFoundException(id);
        }
    }

    public boolean deleteStore(String id){
        if(storeRepository.existsById(id)){
            storeRepository.deleteById(id);
            return true;
        }else{
            throw new StoreNotFoundException(id);
        }
    }
}
