package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.DTOs.ProductDTO;
import com.gestion_tiendas_nosql.Exceptions.ProductNotFoundException;
import com.gestion_tiendas_nosql.Entities.Product;
import com.gestion_tiendas_nosql.Services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Tag(name="Product Services Controller")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    @Operation(summary = "This method returns a list of the existing products")
    public ResponseEntity<?> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("{id}")
    @Operation(summary = "This method returns a product with the specific id")
    public ResponseEntity<?> getProductByID(@PathVariable("id") String id){
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        }catch (ProductNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    @Operation(summary = "This method creates a new product")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productCreateRequest){
        return ResponseEntity.ok(productService.createProduct(productCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing product")
    public ResponseEntity<?> updateProduct(@PathVariable("id") String id, @RequestBody ProductDTO productUpdateRequest) {
        try {
            Product updatedProduct = productService.updateProduct(id, productUpdateRequest);
            return ResponseEntity.ok(updatedProduct);
        }catch (ProductNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping
    @Operation(summary = "This method deletes a product")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        }catch (ProductNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
