package com.gestion_tiendas_nosql.Services;

import com.gestion_tiendas_nosql.DTOs.ProviderDTO;
import com.gestion_tiendas_nosql.Exceptions.ProviderNotFoundException;
import com.gestion_tiendas_nosql.Entities.Provider;
import com.gestion_tiendas_nosql.Repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getProviders(){ return providerRepository.findAll(); }

    public Provider getProviderById(String id){
        Optional<Provider> provider = providerRepository.findById(id);
        if(provider.isPresent()){
            return provider.get();
        }else {
            throw new ProviderNotFoundException(id);
        }
    }

    public Provider createProvider(ProviderDTO providerDTO){
        Provider provider = Provider
                .builder()
                .name(providerDTO.getName())
                .address(providerDTO.getAddress())
                .contact(providerDTO.getContact())
                .suppliedProducts(providerDTO.getSuppliedProducts())
                .build();

        return providerRepository.save(provider);
    }

    public Provider updateProvider(String id, ProviderDTO providerDTO){
        Optional<Provider> optionalProvider = providerRepository.findById(id);
        if(optionalProvider.isPresent()){
            Provider existingProvider = optionalProvider.get();
            existingProvider.setAddress(providerDTO.getAddress());
            existingProvider.setName(providerDTO.getName());
            existingProvider.setContact(providerDTO.getContact());
            existingProvider.setSuppliedProducts(providerDTO.getSuppliedProducts());
            return providerRepository.save(existingProvider);
        }else {
            throw new ProviderNotFoundException(id);
        }
    }

    public boolean deleteProvider(String id){
        if(providerRepository.existsById(id)){
            providerRepository.deleteById(id);
            return true;
        } else {
            throw new ProviderNotFoundException(id);
        }
    }
}
