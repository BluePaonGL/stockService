package fr.isep.stockservice.application.port;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.domain.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductServicePort {
    Product saveProduct(ProductDTO productDTO, MultipartFile image) throws IOException;
    Product getProductByName(String name);
    Product getProductById(Long id_product);
    Product editProduct(ProductDTO productDTO, Long id);
    List<Product> getProducts();
    
    void deleteProduct(Long id);
}
