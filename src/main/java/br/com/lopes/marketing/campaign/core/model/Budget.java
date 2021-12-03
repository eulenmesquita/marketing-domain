package br.com.lopes.marketing.campaign.core.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Budget {
    private final String id;
    private final List<BudgetItem> items;
    private final CurrencyUnit currencyUnit;
    private Money totalCost;

    public Budget(String id, CurrencyUnit currencyUnit, List<BudgetItem> items) {
        checkNotNull(items);
        if (items.isEmpty()) {
            throw new IllegalArgumentException("Budget must have at least one item");
        }
        this.id = id;
        this.currencyUnit = currencyUnit;
        this.items = new ArrayList<>(items);
        totalCost = calculateTotalCost();

    }

    void addLineItem(BudgetItem budgetItem) {
        checkNotNull(budgetItem);
        items.add(budgetItem);
        totalCost = totalCost.plus(budgetItem.cost());
    }

    void removeBudgetItem(int number) {
        BudgetItem removed = items.remove(number);
        totalCost = totalCost.minus(removed.cost());
    }

    public Money totalCost() {
        return totalCost;
    }

    private Money calculateTotalCost() {
        BigDecimal total = items.stream()
                .map(BudgetItem::cost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new Money(total, this.currencyUnit);
    }

    private void checkNotNull(Collection<BudgetItem> items) {
    }

    private void checkNotNull(BudgetItem budgetItem) {
    }

}

