package fr.isep.stockservice.domain.criteria;

import fr.isep.stockservice.domain.model.ProductType;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class ProductCriteria {
    private String name;
    private Date peremptionDate;
    private ProductType type;
    private Integer pageNumber;
    private Integer pageSize;
}
