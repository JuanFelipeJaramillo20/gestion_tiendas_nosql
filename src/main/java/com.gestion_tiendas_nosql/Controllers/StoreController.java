package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.DTOs.StoreDTO;
import com.gestion_tiendas_nosql.Exceptions.StoreNotFoundException;
import com.gestion_tiendas_nosql.Entities.Store;
import com.gestion_tiendas_nosql.Services.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@Tag(name="Store Services Controller")
public class StoreController {
    @Autowired
    StoreService storeService;

    @GetMapping()
    @Operation(summary = "This method returns a list of the existing stores")
    public ResponseEntity<?> getStores(){
        return ResponseEntity.ok(storeService.getStores());
    }

    @GetMapping("{id}")
    @Operation(summary = "This method returns a store with the specific id")
    public ResponseEntity<?> getStoreByID(@PathVariable("id") String id){
        try {
            Store store = storeService.getStoreById(id);
            return ResponseEntity.ok(store);
        }catch (StoreNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/inventory/{id}")
    @Operation(summary = "This method returns the inventory of a store with the specific id")
    public ResponseEntity<?> getStoreInventory(@PathVariable("id") String id){
        try {
            Store store = storeService.getStoreById(id);
            return ResponseEntity.ok(store.getProducts());
        }catch (StoreNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    @Operation(summary = "This method creates a new store")
    public ResponseEntity<?> createStore(@RequestBody StoreDTO storeCreateRequest){
        return ResponseEntity.ok(storeService.createStore(storeCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing store")
    public ResponseEntity<?> updateStore(@PathVariable("id") String id, @RequestBody StoreDTO storeUpdateRequest) {
        try {
            Store updatedStore = storeService.updateStore(id, storeUpdateRequest);
            return ResponseEntity.ok(updatedStore);
        }catch (StoreNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping
    @Operation(summary = "This method deletes a store")
    public ResponseEntity<?> deleteStore(@PathVariable("id") String id) {
        try {
            storeService.deleteStore(id);
            return ResponseEntity.ok().build();
        }catch (StoreNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
