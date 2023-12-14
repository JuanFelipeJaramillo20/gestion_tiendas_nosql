package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.DTOs.InventoryDTO;
import com.gestion_tiendas_nosql.Exceptions.InventoryNotFoundException;
import com.gestion_tiendas_nosql.Entities.Inventory;
import com.gestion_tiendas_nosql.Services.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@Tag(name="Inventory Services Controller")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping()
    @Operation(summary = "This method returns a list of the existing inventories")
    public ResponseEntity<?> getInventories(){
        return ResponseEntity.ok(inventoryService.getInventories());
    }

    @GetMapping("{id}")
    @Operation(summary = "This method returns an inventory with the specific id")
    public ResponseEntity<?> getInventoryByID(@PathVariable("id") String id){
        try {
            Inventory inventory = inventoryService.getInventoryById(id);
            return ResponseEntity.ok(inventory);
        } catch (InventoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    @Operation(summary = "This method creates a new inventory")
    public ResponseEntity<?> createInventory(@RequestBody InventoryDTO inventoryCreateRequest){
        return ResponseEntity.ok(inventoryService.createInventory(inventoryCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing inventory")
    public ResponseEntity<?> updateInventory(@PathVariable("id") String id, @RequestBody InventoryDTO inventoryUpdateRequest) {
        try {
            Inventory updatedInventory = inventoryService.updateInventory(id, inventoryUpdateRequest);
            return ResponseEntity.ok(updatedInventory);
        } catch (InventoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping
    @Operation(summary = "This method deletes an inventory")
    public ResponseEntity<?> deleteInventory(@PathVariable("id") String id) {
        try {
            inventoryService.deleteInventory(id);
            return ResponseEntity.ok().build();
        } catch (InventoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
