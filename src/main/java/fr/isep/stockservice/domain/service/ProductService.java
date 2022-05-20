package fr.isep.stockservice.domain.service;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.application.port.ProductServicePort;
import fr.isep.stockservice.domain.model.Product;
import fr.isep.stockservice.domain.port.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

// Gestion de la logique métier
@RequiredArgsConstructor
@Service
public class ProductService implements ProductServicePort {

    private final ProductRepositoryPort productRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public Product getProduct(String name) {
        return null;
    }

    @Override
    public Product getProductById(String id_product) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }
}
