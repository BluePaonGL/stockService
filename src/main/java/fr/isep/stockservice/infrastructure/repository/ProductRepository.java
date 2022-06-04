package fr.isep.stockservice.infrastructure.repository;

import fr.isep.stockservice.domain.model.Product;
import fr.isep.stockservice.infrastructure.DAO.ProductDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductDAO, Long>, JpaSpecificationExecutor<ProductDAO> {
    ProductDAO findByProductId(Long id);
    ProductDAO findByName(String name);
    List<ProductDAO> findByPeremptionDate(Date peremptionDate);
    List<ProductDAO> findProductDAOByName(String listOfName);
    List<ProductDAO> findProductDAOByType(String listOfType);
    //List<ProductDAO> findProductDAOByDate(String listOfName);
}
