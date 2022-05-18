package fr.isep.stockservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_product;
    private String name;
    private String description;
    private int quantity;
    private ProductType type;
    private Date peremption_date;
    private Date comsumption_data;
    private Set<String> allergen_set;
    private Set<Long> id_lists;

    Product(){};

}
