package fr.isep.stockservice.infrastructure.helper;

import fr.isep.stockservice.domain.model.ProductType;
import fr.isep.stockservice.infrastructure.DAO.ProductDAO;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Calendar;
import java.util.Date;

// A utiliser pour les filtre - Aide
@NoArgsConstructor
public class StockRepositorySpecification {
    public static Specification<ProductDAO> nameEquals(String name) {
        return (root, query, criteriaBuilder) -> {
            if(name != null) {
                return criteriaBuilder.equal(root.get("name"), name);
            } else {
                return criteriaBuilder.conjunction();
            }

        };
    }


    public static Specification<ProductDAO> typeEquals(ProductType type) {
        return (root, query, criteriaBuilder) -> {
            if(type != null) {
                return criteriaBuilder.equal(root.get("type"), type);
            } else {
                return criteriaBuilder.conjunction();
            }

        };
    }

    public static Specification<ProductDAO> peremptionDateInTwoWeeks(Date peremptionDate,int noOfWeek) {
        int noOfDays = 7*noOfWeek;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(peremptionDate);
        calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
        Date dateInTwoWeeks = calendar.getTime();
        return (root, query, criteriaBuilder) -> {
            if(peremptionDate != null) {
                return criteriaBuilder.between(root.get("peremptionDate"),peremptionDate,dateInTwoWeeks);
            } else {
                return criteriaBuilder.conjunction();
            }

        };
    }
}
