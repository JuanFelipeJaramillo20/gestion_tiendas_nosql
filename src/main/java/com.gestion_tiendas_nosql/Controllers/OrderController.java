package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.Entities.Order;
import com.gestion_tiendas_nosql.Services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Tag(name="Order Services Controller")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping()
    @Operation(summary = "This method returns a list of the existing orders")
    public ResponseEntity<?> getOrders(){
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("{id}")
    @Operation(summary = "This method returns an order with the specific id")
    public ResponseEntity<?> getOrderByID(@PathVariable("id") String id){
        return ResponseEntity.ok(orderService.getOrderByID(id));
    }

    @PostMapping()
    @Operation(summary = "This method creates a new order")
    public ResponseEntity<?> createOrder(@RequestBody OrderCreateRequest orderCreateRequest){
        return ResponseEntity.ok(orderService.createOrder(orderCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing order")
    public ResponseEntity<?> updateOrder(@PathVariable("id") String id, @RequestBody OrderUpdateRequest orderUpdateRequest) {
        if (!orderService.orderExists(id)) {
            return ResponseEntity.notFound().build();
        }

        Order updatedOrder = orderService.updateOrder(id, orderUpdateRequest);

        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping
    @Operation(summary = "This method deletes an order")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") String id) {
        if (!orderService.orderExists(id)) {
            return ResponseEntity.notFound().build();
        }

        orderService.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }
}
