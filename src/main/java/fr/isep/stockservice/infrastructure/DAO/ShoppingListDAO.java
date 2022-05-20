package fr.isep.stockservice.infrastructure.DAO;

import fr.isep.stockservice.domain.model.Product;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="'shoppingList'")
public class ShoppingListDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long listID;

    @Column(unique = true)
    private String listname;
    private Set<Product> productList;

    @ManyToOne(targetEntity = ProductDAO.class)
    private ProductDAO productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ShoppingListDAO that = (ShoppingListDAO) o;
        return listID != null && Objects.equals(listID, that.listID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
