package fr.isep.stockservice.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Data
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long listID;
    private String listname;
    private Set<String> productList;
}
