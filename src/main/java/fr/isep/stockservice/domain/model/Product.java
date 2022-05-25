package fr.isep.stockservice.domain.model;

import com.google.common.annotations.VisibleForTesting;
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
    private Date consumptionDate;
    private String allergenSet = "";

    public String addAllergen(String allergen) {
        if (allergenSet.isEmpty()) {
            return allergenSet = allergen;
        }
        return allergenSet += "," + allergen;
    }
/*
    public String addShoppingListId(Long id) {
        if (idLists.isEmpty()) {
            return idLists = String.valueOf(id);
        }
        return idLists += "," + String.valueOf(id);
    }
*/
}
