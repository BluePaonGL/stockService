package fr.isep.stockservice.domain.port;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.domain.criteria.ProductCriteria;
import fr.isep.stockservice.domain.model.Product;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface ProductRepositoryPort {
    Product findById(Long id_product);
    Product findByName(String name);
    Product save(Product product);
    List<Product> findAll();
    Page<Product> pageProductPeremptionDate(ProductCriteria productCriteria);
    Page<Product> pageProductName(ProductCriteria productCriteria);
    Page<Product> pageProductType(ProductCriteria productCriteria);
    void deleteProduct(Long productId);

}
