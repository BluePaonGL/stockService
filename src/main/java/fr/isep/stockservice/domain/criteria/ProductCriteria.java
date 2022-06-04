package fr.isep.stockservice.domain.criteria;

import fr.isep.stockservice.domain.model.ProductType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductCriteria {
    private String name;
    private ProductType type;
    private Integer pageNumber;
    private Integer pageSize;
}
