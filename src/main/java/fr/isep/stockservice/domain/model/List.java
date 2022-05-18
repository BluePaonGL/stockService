package fr.isep.stockservice.domain.model;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class List {
    private Set<Product> product_list;
}
