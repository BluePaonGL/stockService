package fr.isep.stockservice.domain.service;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.application.port.ProductServicePort;
import fr.isep.stockservice.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

// Gestion de la logique métier
@Service
public class ProductService implements ProductServicePort {

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
