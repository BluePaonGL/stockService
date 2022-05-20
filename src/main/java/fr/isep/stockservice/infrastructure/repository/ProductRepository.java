package fr.isep.stockservice.infrastructure.repository;

import fr.isep.stockservice.domain.model.Product;
import fr.isep.stockservice.infrastructure.DAO.ProductDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    ProductDAO findByProductID(Long id);

    ProductDAO findByName(String name);
}
