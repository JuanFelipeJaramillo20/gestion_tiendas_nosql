package com.gestion_tiendas_nosql.Services;

import com.gestion_tiendas_nosql.DTOs.ClientDTO;
import com.gestion_tiendas_nosql.Exceptions.ClientNotFoundException;
import com.gestion_tiendas_nosql.Entities.Client;
import com.gestion_tiendas_nosql.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Client getClientByID(String id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()){
            return client.get();
        }else{
            throw new ClientNotFoundException(id);
        }
    }

    public Client createClient(ClientDTO clientCreateRequest){
        Client client = Client.builder()
                .fullName(clientCreateRequest.getFullName())
                .address(clientCreateRequest.getAddress())
                .phoneNumber(clientCreateRequest.getPhoneNumber())
                .orderHistory(clientCreateRequest.getOrderHistory())
                .build();

        return clientRepository .save(client);
    }

    public Client updateClient(String id, ClientDTO updatedClientDTO) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setFullName(updatedClientDTO.getFullName());
            existingClient.setAddress(updatedClientDTO.getAddress());
            existingClient.setPhoneNumber(updatedClientDTO.getPhoneNumber());
            existingClient.setOrderHistory(updatedClientDTO.getOrderHistory());

            return clientRepository.save(existingClient);
        } else {
            throw new ClientNotFoundException(id);
        }
    }

    public boolean deleteClient(String id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        } else {
            throw new ClientNotFoundException(id);
        }
    }
}
