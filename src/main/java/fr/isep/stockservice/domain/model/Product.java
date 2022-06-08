package fr.isep.stockservice.domain.model;

import fr.isep.stockservice.application.DTO.ProductDTO;
import lombok.Data;
import java.util.Date;


@Data
public class Product {
    private Long productId;
    private String name;
    private String description;
    private Long quantity;
    private ProductType type;
    private Date peremptionDate;
    private Date consumptionDate;
    private String allergenSet;
    private String image;

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
