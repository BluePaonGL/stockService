package fr.isep.stockservice.infrastructure.repository;

import fr.isep.stockservice.domain.model.ShoppingList;
import fr.isep.stockservice.infrastructure.DAO.ShoppingListDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    // findById ; save ; findAll ; findByProduct_type...
    ShoppingListDAO findByListID(Long id);

    ShoppingListDAO findByListname(String listname);
}
