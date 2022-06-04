package fr.isep.stockservice.application.port;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.domain.criteria.ProductCriteria;
import fr.isep.stockservice.domain.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductServicePort {
    Product saveProduct(ProductDTO productDTO);
    Product getProductByName(String name);
    Product getProductById(Long id_product);
    Product editProduct(ProductDTO productDTO, Long id);
    List<Product> getProducts();
    Page<Product> pageProductName(ProductCriteria productCriteria);
    Page<Product> pageProductType(ProductCriteria productCriteria);
    void deleteProduct(Long id);
}
