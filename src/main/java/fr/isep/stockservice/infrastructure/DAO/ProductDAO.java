package fr.isep.stockservice.infrastructure.DAO;

import fr.isep.stockservice.domain.model.ProductType;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private Long productId;

    @Column(unique = true)
    private String name;
    private String description;
    private Long quantity;
    @Enumerated(value = EnumType.STRING)
    private ProductType type;
    @Temporal(TemporalType.DATE)
    private Date peremptionDate;
    @Temporal(TemporalType.DATE)
    private Date consumptionDate;
    //private String allergenSet = "";

    //@OneToMany(targetEntity = fr.isep.stockservice.infrastructure.DAO.ShoppingListDAO.class)
    //@ToString.Exclude
    //private Set<Integer> idLists;

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
