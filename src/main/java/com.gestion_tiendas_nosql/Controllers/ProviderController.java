package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.DTOs.ProviderDTO;
import com.gestion_tiendas_nosql.Exceptions.ProviderNotFoundException;
import com.gestion_tiendas_nosql.Entities.Provider;
import com.gestion_tiendas_nosql.Services.ProviderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider")
@Tag(name="Provider Services Controller")
public class ProviderController {
    @Autowired
    ProviderService providerService;

    @GetMapping()
    @Operation(summary = "This method returns a list of the existing providers")
    public ResponseEntity<?> getProviders(){
        return ResponseEntity.ok(providerService.getProviders());
    }

    @GetMapping("{id}")
    @Operation(summary = "This method returns a provider with the specific id")
    public ResponseEntity<?> getProviderByID(@PathVariable("id") String id){
        try {
            Provider provider = providerService.getProviderById(id);
            return ResponseEntity.ok(provider);
        }catch (ProviderNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    @Operation(summary = "This method creates a new provider")
    public ResponseEntity<?> createProvider(@RequestBody ProviderDTO providerCreateRequest){
        return ResponseEntity.ok(providerService.createProvider(providerCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing provider")
    public ResponseEntity<?> updateProvider(@PathVariable("id") String id, @RequestBody ProviderDTO providerUpdateRequest) {
        try {
            Provider updatedProvider = providerService.updateProvider(id, providerUpdateRequest);
            return ResponseEntity.ok(updatedProvider);
        }catch (ProviderNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping
    @Operation(summary = "This method deletes a provider")
    public ResponseEntity<?> deleteProvider(@PathVariable("id") String id) {
        try {
            providerService.deleteProvider(id);
            return ResponseEntity.ok().build();
        }catch (ProviderNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
