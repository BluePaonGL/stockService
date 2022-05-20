package fr.isep.stockservice.application.port;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.domain.model.Product;

import java.util.List;

public interface ProductServicePort {
    Product saveProduct(ProductDTO productDTO);
    Product getProduct(String name);
    Product getProductById(String id_product);

    List<Product> getProducts();
}
