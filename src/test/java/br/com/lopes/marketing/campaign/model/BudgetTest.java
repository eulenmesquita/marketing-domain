package br.com.lopes.marketing.campaign.model;

import br.com.lopes.marketing.campaign.core.model.*;
import br.com.lopes.marketing.campaign.model.fixtures.BudgetFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BudgetTest {

    @Test
    @DisplayName("Should create a new Budget")
    void shouldCreateBudget() {
        Budget budget = BudgetFixture.valid();

        Money expectedCost = new Money(new BigDecimal(25), CurrencyUnit.BRL);

        assertThat(expectedCost).isEqualTo(budget.totalCost());
    }


}