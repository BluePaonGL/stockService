package fr.isep.stockservice.domain.model;

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

    private String value;

    Allergen(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
