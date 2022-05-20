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

@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productID;
    private String name;
    private String description;
    private int quantity;
    private ProductType type;
    private Date peremptionDate;
    private Date comsumptionDate;
    private Set<String> allergenSet;
    private Set<Long> idLists;

}
