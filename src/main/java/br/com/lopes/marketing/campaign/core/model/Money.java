package br.com.lopes.marketing.campaign.core.model;

import java.math.BigDecimal;

public class Money {
    private BigDecimal amount;
    private CurrencyUnit currencyUnit;

    public Money(BigDecimal amount, CurrencyUnit currencyUnit) {
        if (amount == null || currencyUnit == null) {
            throw new IllegalArgumentException("amount and currency are required for money");
        }
        this.amount = amount;
        this.currencyUnit = currencyUnit;
    }

    public static Money zero(CurrencyUnit code) {
        return new Money(BigDecimal.ZERO, code);
    }

    public CurrencyUnit getCurrencyUnit() {
        return this.currencyUnit;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public Money plus(BigDecimal amount) {
        return new Money(this.amount.add(amount), this.currencyUnit);
    }

    public Money minus(BigDecimal amount) {
        return new Money(this.amount.subtract(amount), this.currencyUnit);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Money))
            return false;

        Money other = (Money) object;
        return other.currencyUnit.equals(this.currencyUnit)
                && other.amount.compareTo(this.amount) == 0;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.amount, this.currencyUnit.name());
    }

}
