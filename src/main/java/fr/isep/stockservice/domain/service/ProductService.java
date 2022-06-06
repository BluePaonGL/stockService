package fr.isep.stockservice.domain.service;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.application.port.ProductServicePort;
import fr.isep.stockservice.domain.criteria.ProductCriteria;
import fr.isep.stockservice.domain.model.Product;
import fr.isep.stockservice.domain.port.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

// Gestion de la logique métier
@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService implements ProductServicePort {

    private final ProductRepositoryPort productRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        return this.productRepositoryPort.save(product);
    }

    @Override
    public Product saveProductWithImage(ProductDTO productDTO, MultipartFile image) throws IOException {
        Product product = modelMapper.map(productDTO, Product.class);
        product.setImage(image.getBytes());
        return this.productRepositoryPort.save(product);
    }

    @Override
        public Product editProduct(ProductDTO productDTO,Long id) {
            Product product = modelMapper.map(productDTO, Product.class);
            product.setProductId(id);
            return this.productRepositoryPort.save(product);
        }

    @Override
    public Product editProductWithImage(ProductDTO productDTO, Long id, MultipartFile image) throws IOException {
        Product product = modelMapper.map(productDTO, Product.class);
        product.setProductId(id);
        product.setImage(image.getBytes());
        return this.productRepositoryPort.save(product);
    }

    @Override
    @Transactional
    public Product getProductByName(String name) {
        Product product = this.productRepositoryPort.findByName(name);
        return product;
    }

    @Override
    @Transactional
    public Product getProductById(Long id_product) {
        Product product = this.productRepositoryPort.findById(id_product);
        return product;
    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        List<Product> result = this.productRepositoryPort.findAll();
        return result;
    }

    @Override
    public Page<Product> pageProductName(ProductCriteria productCriteria) {
        return this.productRepositoryPort.pageProductName(productCriteria);
    }

    @Override
    public Page<Product> pageProductType(ProductCriteria productCriteria) {
        return this.productRepositoryPort.pageProductType(productCriteria);
    }

    @Override
    public Page<Product> pageProductPeremptionDate(ProductCriteria productCriteria,int noOfWeek) {
        return this.productRepositoryPort.pageProductPeremptionDate(productCriteria,noOfWeek);
    }


    @Override
    public void deleteProduct(Long id) {
        this.productRepositoryPort.deleteProduct(id);
    }
    
    

}
