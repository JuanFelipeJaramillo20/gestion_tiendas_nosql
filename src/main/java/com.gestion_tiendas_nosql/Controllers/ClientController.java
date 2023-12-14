package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.DTOs.ClientDTO;
import com.gestion_tiendas_nosql.Exceptions.ClientNotFoundException;
import com.gestion_tiendas_nosql.Entities.Client;
import com.gestion_tiendas_nosql.Services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try {
            Client client = clientService.getClientByID(id);
            return ResponseEntity.ok(client);
        }catch (ClientNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    @Operation(summary = "This method creates a new client")
    public ResponseEntity<?> createClient(@RequestBody ClientDTO clientCreateRequest){
        return ResponseEntity.ok(clientService.createClient(clientCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing client")
    public ResponseEntity<?> updateClient(@PathVariable("id") String id, @RequestBody ClientDTO clientUpdateRequest) {
        try {
            Client updatedClient = clientService.updateClient(id, clientUpdateRequest);
            return ResponseEntity.ok(updatedClient);
        }catch (ClientNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping
    @Operation(summary = "This method deletes a client")
    public ResponseEntity<?> deleteClient(@PathVariable("id") String id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.ok().build();
        }catch (ClientNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
