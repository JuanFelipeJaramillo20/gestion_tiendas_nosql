package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.Entities.Report;
import com.gestion_tiendas_nosql.Entities.Store;
import com.gestion_tiendas_nosql.Services.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(storeService.getStoreByID(id));
    }

    @PostMapping()
    @Operation(summary = "This method creates a new store")
    public ResponseEntity<?> createStore(@RequestBody StoreCreateRequest storeCreateRequest){
        return ResponseEntity.ok(storeService.createStore(storeCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing store")
    public ResponseEntity<?> updateStore(@PathVariable("id") String id, @RequestBody StoreUpdateRequest storeUpdateRequest) {
        if (!storeService.storeExists(id)) {
            return ResponseEntity.notFound().build();
        }

        Store updatedStore = storeService.updateStore(id, storeUpdateRequest);

        return ResponseEntity.ok(updatedStore);
    }

    @DeleteMapping
    @Operation(summary = "This method deletes a store")
    public ResponseEntity<?> deleteStore(@PathVariable("id") String id) {
        if (!storeService.storeExists(id)) {
            return ResponseEntity.notFound().build();
        }

        storeService.deleteStore(id);

        return ResponseEntity.noContent().build();
    }
}
