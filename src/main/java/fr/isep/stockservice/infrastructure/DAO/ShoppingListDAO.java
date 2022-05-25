package fr.isep.stockservice.infrastructure.DAO;

import fr.isep.stockservice.domain.model.Product;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
/*
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
*/
@Table(name="shoppingList")
public class ShoppingListDAO {
    @Id
    private Long ListId;
}
