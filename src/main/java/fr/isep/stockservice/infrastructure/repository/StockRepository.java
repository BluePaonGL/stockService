package fr.isep.stockservice.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
    // findById ; save ; findAll ; findByProduct_type...
}
