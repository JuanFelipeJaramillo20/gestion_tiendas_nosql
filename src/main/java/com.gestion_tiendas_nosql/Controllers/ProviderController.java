package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.Entities.Product;
import com.gestion_tiendas_nosql.Services.ProductService;
import com.gestion_tiendas_nosql.Services.ProviderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(providerService.getProviderByID(id));
    }

    @PostMapping()
    @Operation(summary = "This method creates a new provider")
    public ResponseEntity<?> createProvider(@RequestBody ProviderCreateRequest providerCreateRequest){
        return ResponseEntity.ok(providerService.createProvider(providerCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing provider")
    public ResponseEntity<?> updateProvider(@PathVariable("id") String id, @RequestBody ProviderUpdateRequest providerUpdateRequest) {
        if (!providerService.providerExists(id)) {
            return ResponseEntity.notFound().build();
        }

        Product updatedProvider = providerService.updateProvider(id, providerUpdateRequest);

        return ResponseEntity.ok(updatedProvider);
    }

    @DeleteMapping
    @Operation(summary = "This method deletes a provider")
    public ResponseEntity<?> deleteProvider(@PathVariable("id") String id) {
        if (!providerService.providerExists(id)) {
            return ResponseEntity.notFound().build();
        }

        providerService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }
}
