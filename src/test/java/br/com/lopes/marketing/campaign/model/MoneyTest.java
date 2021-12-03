package br.com.lopes.marketing.campaign.model;

import br.com.lopes.marketing.campaign.core.model.CurrencyUnit;
import br.com.lopes.marketing.campaign.core.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

    @Test
    @DisplayName("should not create Money without currency unit or value amount")
    void money_new() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Money(null, CurrencyUnit.BRL);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Money(BigDecimal.ONE, null);
        });
    }

    @Test
    @DisplayName("should create Money with Zero value")
    void money_zero() {
        Money expected = new Money(BigDecimal.ZERO, CurrencyUnit.USD);
        assertThat(Money.zero(CurrencyUnit.USD)).isEqualTo(expected);
    }

}