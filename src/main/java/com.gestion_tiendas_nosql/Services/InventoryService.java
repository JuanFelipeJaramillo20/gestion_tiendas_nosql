package com.gestion_tiendas_nosql.Services;

import com.gestion_tiendas_nosql.DTOs.InventoryDTO;
import com.gestion_tiendas_nosql.Exceptions.InventoryNotFoundException;
import com.gestion_tiendas_nosql.Entities.Inventory;
import com.gestion_tiendas_nosql.Repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getInventories(){ return inventoryRepository.findAll(); }

    public Inventory getInventoryById(String id){
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        if(inventory.isPresent()){
            return inventory.get();
        }else{
            throw new InventoryNotFoundException(id);
        }
    }

    public Inventory createInventory(InventoryDTO newInventoryDTO) {
        Inventory newInventory = Inventory
                .builder()
                .productList(newInventoryDTO.getProductList())
                .reportList(newInventoryDTO.getReportList())
                .build();
        return inventoryRepository.save(newInventory);
    }

    public Inventory updateInventory(String id, InventoryDTO updatedInventoryDTO) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);
        if (optionalInventory.isPresent()) {
            Inventory existingInventory = optionalInventory.get();
            existingInventory.setReportList(updatedInventoryDTO.getReportList());
            existingInventory.setProductList(updatedInventoryDTO.getProductList());
            return inventoryRepository.save(existingInventory);
        } else {
            throw new InventoryNotFoundException(id);
        }
    }

    public boolean deleteInventory(String id) {
        if (inventoryRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
            return true;
        } else {
            throw new InventoryNotFoundException(id);
        }
    }
}
