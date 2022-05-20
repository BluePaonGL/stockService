package fr.isep.stockservice.domain.port;

import fr.isep.stockservice.domain.model.Product;

public interface ProductRepositoryPort {
    Product findById(String id_product);
    Product findByProductname(String product_name);

}
