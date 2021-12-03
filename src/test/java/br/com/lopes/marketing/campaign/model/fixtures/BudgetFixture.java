package br.com.lopes.marketing.campaign.model.fixtures;

import br.com.lopes.marketing.campaign.core.model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class BudgetFixture {

    public static Budget valid() {
        Product product1 = new Product("ABC132", new Money(BigDecimal.ONE, CurrencyUnit.BRL));
        Product product2 = new Product("XPO955", new Money(BigDecimal.TEN, CurrencyUnit.BRL));
        BudgetItem budgetItem1 = new BudgetItem(product1, 5);
        BudgetItem budgetItem2 = new BudgetItem(product2, 2);

        final String id = UUID.randomUUID().toString();

        return new Budget(id, CurrencyUnit.BRL, List.of(budgetItem1, budgetItem2));
    }
}
