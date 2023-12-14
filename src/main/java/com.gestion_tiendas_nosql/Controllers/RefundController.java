package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.DTOs.RefundDTO;
import com.gestion_tiendas_nosql.Exceptions.RefundNotFoundException;
import com.gestion_tiendas_nosql.Entities.Refund;
import com.gestion_tiendas_nosql.Services.RefundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try {
            Refund refund = refundService.getRefundById(id);
            return ResponseEntity.ok(refund);
        }catch (RefundNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    @Operation(summary = "This method creates a new refund")
    public ResponseEntity<?> createRefund(@RequestBody RefundDTO refundCreateRequest){
        return ResponseEntity.ok(refundService.createRefund(refundCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing refund")
    public ResponseEntity<?> updateRefund(@PathVariable("id") String id, @RequestBody RefundDTO refundUpdateRequest) {
        try {
            Refund updatedRefund = refundService.updateRefund(id, refundUpdateRequest);
            return ResponseEntity.ok(updatedRefund);
        }catch (RefundNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping
    @Operation(summary = "This method deletes a provider")
    public ResponseEntity<?> deleteRefund(@PathVariable("id") String id) {
        try {
            refundService.deleteRefund(id);
            return ResponseEntity.ok().build();
        }catch (RefundNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
