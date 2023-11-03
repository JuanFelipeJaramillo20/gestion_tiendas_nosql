package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.Entities.Client;
import com.gestion_tiendas_nosql.Services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@Tag(name="Client Services Controller")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping()
    @Operation(summary = "This method returns a list of the existing clients")
    public ResponseEntity<?> getClients(){
        return ResponseEntity.ok(clientService.getClients());
    }

    @GetMapping("{id}")
    @Operation(summary = "This method returns a client with the specific id")
    public ResponseEntity<?> getClientByID(@PathVariable("id") String id){
        return ResponseEntity.ok(clientService.getClientByID(id));
    }

    @PostMapping()
    @Operation(summary = "This method creates a new client")
    public ResponseEntity<?> createClient(@RequestBody ClientCreateRequest clientCreateRequest){
        return ResponseEntity.ok(clientService.createClient(clientCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing client")
    public ResponseEntity<?> updateClient(@PathVariable("id") String id, @RequestBody ClientUpdateRequest clientUpdateRequest) {
        // First, check if the client with the given id exists
        if (!clientService.clientExists(id)) {
            return ResponseEntity.notFound().build();
        }

        // Then, update the client with the new information
        Client updatedClient = clientService.updateClient(id, clientUpdateRequest);

        // Return the updated client
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping
    @Operation(summary = "This method deletes a client")
    public ResponseEntity<?> deleteClient(@PathVariable("id") String id) {
        // First, check if the client with the given id exists
        if (!clientService.clientExists(id)) {
            return ResponseEntity.notFound().build();
        }

        // Then, delete the client
        clientService.deleteClient(id);

        // Return a 204 No Content response to indicate successful deletion
        return ResponseEntity.noContent().build();
    }
}
