package fr.isep.stockservice.application.port;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.domain.criteria.ProductCriteria;
import fr.isep.stockservice.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductServicePort {
    Product getProductByName(String name);
    Product getProductById(Long id_product);
    List<Product> getProducts();
    Page<Product> pageProductName(ProductCriteria productCriteria);
    Page<Product> pageProductType(ProductCriteria productCriteria);
    Page<Product> pageProductPeremptionDate(ProductCriteria productCriteria,int noOfWeek);
    void deleteProduct(Long id);
    Product saveProduct(ProductDTO productDTO);
    Product editProduct(ProductDTO productDTO, Long id);
    //Product saveProductWithImage(ProductDTO productDTO, MultipartFile image) throws IOException;

    //Product editProductWithImage(ProductDTO productDTO, Long id, MultipartFile image) throws IOException;
}
