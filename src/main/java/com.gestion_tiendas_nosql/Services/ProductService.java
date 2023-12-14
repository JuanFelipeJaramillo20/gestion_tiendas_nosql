package com.gestion_tiendas_nosql.Services;

import com.gestion_tiendas_nosql.DTOs.ProductDTO;
import com.gestion_tiendas_nosql.Exceptions.ProductNotFoundException;
import com.gestion_tiendas_nosql.Entities.Product;
import com.gestion_tiendas_nosql.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){ return productRepository.findAll(); }

    public Product getProductById(String id){
        Optional<Product> order = productRepository.findById(id);
        if(order.isPresent()){
            return order.get();
        }else{
            throw new ProductNotFoundException(id);
        }
    }

    public Product createProduct(ProductDTO productDTO){
        Product order = Product
                .builder()
                .name(productDTO.getName())
                .category(productDTO.getCategory())
                .description(productDTO.getDescription())
                .expirationDate(productDTO.getExpirationDate())
                .providers(productDTO.getProviders())
                .serialNumber(productDTO.getSerialNumber())
                .stores(productDTO.getStores())
                .unitPrice(productDTO.getUnitPrice())
                .build();

        return productRepository.save(order);
    }

    public Product updateProduct(String id, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setCategory(productDTO.getCategory());
            existingProduct.setDescription(productDTO.getDescription());
            existingProduct.setName(productDTO.getName());
            existingProduct.setProviders(productDTO.getProviders());
            existingProduct.setStores(productDTO.getStores());
            existingProduct.setExpirationDate(productDTO.getExpirationDate());
            existingProduct.setSerialNumber(productDTO.getSerialNumber());
            existingProduct.setUnitPrice(productDTO.getUnitPrice());
            return productRepository.save(existingProduct);
        } else {
            throw new ProductNotFoundException(id);
        }
    }

    public boolean deleteProduct(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        } else {
            throw new ProductNotFoundException(id);
        }
    }
}
