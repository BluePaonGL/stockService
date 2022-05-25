package fr.isep.stockservice.infrastructure.repository;

import fr.isep.stockservice.domain.model.Product;
import fr.isep.stockservice.infrastructure.DAO.ProductDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<ProductDAO, Long>, JpaSpecificationExecutor<ProductDAO> {
    ProductDAO findByProductID(Long id);

    ProductDAO findByName(String name);
}
