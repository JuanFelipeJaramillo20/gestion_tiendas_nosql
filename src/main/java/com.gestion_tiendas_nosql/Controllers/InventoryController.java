package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.Entities.Inventory;
import com.gestion_tiendas_nosql.Services.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(inventoryService.getInventoryByID(id));
    }

    @PostMapping()
    @Operation(summary = "This method creates a new inventory")
    public ResponseEntity<?> createInventory(@RequestBody InventoryCreateRequest inventoryCreateRequest){
        return ResponseEntity.ok(inventoryService.createInventory(inventoryCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing inventory")
    public ResponseEntity<?> updateInventory(@PathVariable("id") String id, @RequestBody InventoryUpdateRequest inventoryUpdateRequest) {
        if (!inventoryService.inventoryExists(id)) {
            return ResponseEntity.notFound().build();
        }

        Inventory updatedInventory = inventoryService.updateInventory(id, inventoryUpdateRequest);

        return ResponseEntity.ok(updatedInventory);
    }

    @DeleteMapping
    @Operation(summary = "This method deletes an inventory")
    public ResponseEntity<?> deleteInventory(@PathVariable("id") String id) {
        if (!inventoryService.inventoryExists(id)) {
            return ResponseEntity.notFound().build();
        }

        inventoryService.deleteInventory(id);

        return ResponseEntity.noContent().build();
    }
}
