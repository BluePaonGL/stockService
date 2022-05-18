package fr.isep.stockservice.infrastructure.repository;

import fr.isep.stockservice.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
