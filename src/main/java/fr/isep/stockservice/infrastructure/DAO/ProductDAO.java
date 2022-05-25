package fr.isep.stockservice.infrastructure.DAO;

import fr.isep.stockservice.domain.model.ProductType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

// Lien avec la BDD
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class ProductDAO {
    @Id
    private Long productId;

    @Column(unique = true)
    private String name;
    private String description;
    private int quantity;
    private ProductType type;
    private Date peremptionDate;
    private Date consumptionDate;
    private String allergenSet = "";
    private String idLists = "";

    @OneToMany(targetEntity = fr.isep.stockservice.infrastructure.DAO.ShoppingListDAO.class)
    private Set<Long> idLists;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductDAO product = (ProductDAO) o;
        return productId != null && Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
