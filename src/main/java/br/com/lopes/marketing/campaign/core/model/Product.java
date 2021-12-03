package br.com.lopes.marketing.campaign.core.model;

import java.math.BigDecimal;

public class Product {
    private String sku;
    private final Money price;
    private final String description;

    public Product(String description, Money price) {
        if (description == null || price == null) {
            throw new IllegalArgumentException("description and product price can not be null");
        }
        this.description = description;
        this.price = price;
    }

    public void setSku(String sku) {
        if (sku == null || "".equals(sku)) {
            throw new IllegalArgumentException("description can not be null or empty");
        }
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return price.getAmount();
    }

    public String getDescription() {
        return this.description;
    }

    public String getSku() {
        return this.sku;
    }

}
