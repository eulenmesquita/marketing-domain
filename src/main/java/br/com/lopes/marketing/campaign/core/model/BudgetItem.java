package br.com.lopes.marketing.campaign.core.model;

import java.math.BigDecimal;

public class BudgetItem {
    private final Product product;
    private final int quantity;

    public BudgetItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product is invalid for budget item");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be bigger than zero");
        }

        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal cost() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
