package fr.eletutour;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money negate() {
        return new Money(this.amount.negate());
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount));
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }
}
