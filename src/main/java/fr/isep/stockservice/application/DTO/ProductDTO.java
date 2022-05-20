package fr.isep.stockservice.application.DTO;

import fr.isep.stockservice.domain.model.ProductType;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

// Manipulation des champs de l'objet
@Setter(value = AccessLevel.NONE)
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_product;
    @NotNull
    @NotEmpty
    private String name;
    private String description;
    @NotNull
    @NotEmpty
    private int quantity;
    @NotNull
    @NotEmpty
    private ProductType type;
    @DateTimeFormat
    private Date peremption_date;
    @DateTimeFormat
    private Date comsumption_data;
    private Set<String> allergen_set;
    private Set<Long> id_lists;
}
