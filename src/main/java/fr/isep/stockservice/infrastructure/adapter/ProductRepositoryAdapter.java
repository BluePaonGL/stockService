package fr.isep.stockservice.infrastructure.adapter;

import fr.isep.stockservice.domain.model.Product;
import fr.isep.stockservice.domain.port.ProductRepositoryPort;
import fr.isep.stockservice.infrastructure.DAO.ProductDAO;
import fr.isep.stockservice.infrastructure.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
// Les Adapters s'occupent de tout ce qui est filtrage/pagination
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    private ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public Product findById(Long productId) {
        ProductDAO productDaoOptional = this.productRepository.findByProductId(productId);
        try {
            return modelMapper.map(productDaoOptional, Product.class);
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public Product findByName(String name) {
        ProductDAO productDaoOptional = this.productRepository.findByName(name);
        try {
            return modelMapper.map(productDaoOptional, Product.class);
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public Product save(Product product) {
        ProductDAO productDao = modelMapper.map(product, ProductDAO.class);
        return modelMapper.map(this.productRepository.save(productDao), Product.class);
    }



    @Override
    public List<Product> findAll() {
        List<ProductDAO> listDAO = this.productRepository.findAll();

        return listDAO.stream().map(event -> modelMapper.map(event, Product.class)).collect(Collectors.toList());

    }

    @Override
    public void deleteProduct(Long productId) {
        this.productRepository.delete(this.productRepository.findByProductId(productId));
    }
}
