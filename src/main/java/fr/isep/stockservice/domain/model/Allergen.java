package fr.isep.stockservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Allergen {
    GLUTEN("Gluten"),
    LACTOSE("Lactose"),
    EGG("Oeuf"),
    SHELLFISH("Crustacé"),
    FISH("Poisson"),
    PEANUTS("Arachide"),
    NUTS("Fruits à coque"),
    SOY("Soja"),
    MUSTARD("Moutarde"),
    SESAME("Sésame");

    @Getter
    private String value;
    
}
