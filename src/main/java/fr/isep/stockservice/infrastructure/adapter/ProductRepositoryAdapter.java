package fr.isep.stockservice.infrastructure.adapter;

import fr.isep.stockservice.domain.model.Product;
import fr.isep.stockservice.domain.port.ProductRepositoryPort;
import fr.isep.stockservice.infrastructure.DAO.ProductDAO;
import fr.isep.stockservice.infrastructure.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Component
// Les Adapters s'occupent de tout ce qui est filtrage/pagination
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    private ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public Product findById(Long userId) {
        ProductDAO userDaoOptional = this.productRepository.findByProductId(userId);
        try {
            return modelMapper.map(userDaoOptional, Product.class);
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public Product findByProductname(String product_name) {
        return null;
    }

    /*@Override
    public Product save(Product product) {
        ProductDAO productDao = modelMapper.map(product, ProductDAO.class);
        return modelMapper.map(this.productRepository.save(productDao), Product.class);
    }*/

    @Override
    public Product save(Product product) {
        return product;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void delete(Long userId) {

    }
}
