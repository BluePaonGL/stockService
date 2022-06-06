package fr.isep.stockservice.application.DTO;

import fr.isep.stockservice.domain.model.ProductType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

// Manipulation des champs de l'objet
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(value = AccessLevel.NONE)
@Getter
public class ProductDTO implements Serializable {
    //@NotNull
    //@NotEmpty
    private String name;
    private String description;
    //@NotNull
    //@NotEmpty
    private Long quantity;
    //@NotNull
    //@NotEmpty
    private ProductType type;
    private Date peremptionDate;
    private Date consumptionDate;
    private String allergenSet;
    private byte[] image;
}
