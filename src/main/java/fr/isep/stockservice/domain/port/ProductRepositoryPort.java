package fr.isep.stockservice.domain.port;

import fr.isep.stockservice.domain.model.Product;

import java.util.List;

public interface ProductRepositoryPort {
    Product findById(Long id_product);
    Product findByProductname(String product_name);
    Product save(Product product);
    List<Product> findAll();

    void delete(Long productId);

}
