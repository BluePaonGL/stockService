package fr.isep.stockservice.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Set;

@Data
public class ShoppingList {
    private Long listID;
    private String listname;
    private Set<Product> productList;
}
