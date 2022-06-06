package fr.isep.stockservice.domain.service;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.application.port.ProductServicePort;
import fr.isep.stockservice.domain.model.Product;
import fr.isep.stockservice.domain.port.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// Gestion de la logique métier
@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService implements ProductServicePort {

    private ProductRepositoryPort productRepositoryPort;
    private ModelMapper modelMapper;

    @Override
    public Product saveProduct(ProductDTO productDTO, MultipartFile image) throws IOException {
        Product product = modelMapper.map(productDTO, Product.class);
        //product.setImage(image.getBytes());
        return this.productRepositoryPort.save(product);
    }

    @Override
    public Product saveImage(MultipartFile image, Long id) throws IOException {
        Product product = this.productRepositoryPort.findById(id);
        String rootDir = System.getProperty("user.dir")+"/src/main/resources/static";
        Path path = Paths.get(rootDir, image.getOriginalFilename());
        String filename = image.getOriginalFilename();
        Files.write(path, image.getBytes());
        product.setImage(filename);
        return this.productRepositoryPort.save(product);
    }

    @Override
        public Product editProduct(ProductDTO productDTO,Long id) {
            Product product = modelMapper.map(productDTO, Product.class);
            product.setProductId(id);
            return this.productRepositoryPort.save(product);
        }

    @Override
    public Product getProductByName(String name) {
        Product product = this.productRepositoryPort.findByName(name);
        return product;
    }

    @Override
    public Product getProductById(Long id_product) {
        Product product = this.productRepositoryPort.findById(id_product);
        return product;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> result = this.productRepositoryPort.findAll();
        return result;
    }


    @Override
    public void deleteProduct(Long id) {
        this.productRepositoryPort.deleteProduct(id);
    }
}
