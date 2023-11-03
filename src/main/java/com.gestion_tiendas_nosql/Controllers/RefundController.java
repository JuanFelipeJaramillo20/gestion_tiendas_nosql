package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.Entities.Product;
import com.gestion_tiendas_nosql.Entities.Refund;
import com.gestion_tiendas_nosql.Services.ProviderService;
import com.gestion_tiendas_nosql.Services.RefundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refund")
@Tag(name="Refund Services Controller")
public class RefundController {
    @Autowired
    RefundService refundService;

    @GetMapping()
    @Operation(summary = "This method returns a list of the existing refunds")
    public ResponseEntity<?> getRefunds(){
        return ResponseEntity.ok(refundService.getRefunds());
    }

    @GetMapping("{id}")
    @Operation(summary = "This method returns a refund with the specific id")
    public ResponseEntity<?> getRefundByID(@PathVariable("id") String id){
        return ResponseEntity.ok(refundService.getRefundByID(id));
    }

    @PostMapping()
    @Operation(summary = "This method creates a new refund")
    public ResponseEntity<?> createRefund(@RequestBody RefundCreateRequest refundCreateRequest){
        return ResponseEntity.ok(refundService.createRefund(refundCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing refund")
    public ResponseEntity<?> updateRefund(@PathVariable("id") String id, @RequestBody RefundUpdateRequest refundUpdateRequest) {
        if (!refundService.refundExists(id)) {
            return ResponseEntity.notFound().build();
        }

        Refund updatedRefund = refundService.updateRefund(id, refundUpdateRequest);

        return ResponseEntity.ok(updatedRefund);
    }

    @DeleteMapping
    @Operation(summary = "This method deletes a provider")
    public ResponseEntity<?> deleteRefund(@PathVariable("id") String id) {
        if (!refundService.refundExists(id)) {
            return ResponseEntity.notFound().build();
        }

        refundService.deleteRefund(id);

        return ResponseEntity.noContent().build();
    }
}
