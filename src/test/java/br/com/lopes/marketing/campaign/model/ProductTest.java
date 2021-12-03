package br.com.lopes.marketing.campaign.model;

import br.com.lopes.marketing.campaign.core.model.CurrencyUnit;
import br.com.lopes.marketing.campaign.core.model.Money;
import br.com.lopes.marketing.campaign.core.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    @DisplayName("it should create a new product")
    void product_new() {
        Money price = Money.zero(CurrencyUnit.BRL);
        Product product = new Product("new product", price);

        assertThat(product.getPrice()).isEqualTo(price.getAmount());
        assertThat(product.getDescription()).isEqualTo("new product");
    }

    @Test
    @DisplayName("it should fail when product has no price or description")
    void product_with_error() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("new product", new Money(BigDecimal.valueOf(-1), CurrencyUnit.USD));
        }) ;
    }

}