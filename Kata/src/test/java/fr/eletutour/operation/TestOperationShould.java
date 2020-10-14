package fr.eletutour.operation;

import fr.eletutour.Money;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class TestOperationShould {

    @Test
    public void withdrawal_should_returns_negative_amount() {
        // WHEN
        Operation withdrawal = new Operation(new Date(), TypeOperation.WITHDRAWAL, new Money(BigDecimal.valueOf(100)));

        // THEN
        Assertions.assertThat(new Money(BigDecimal.valueOf(-100))).isEqualTo(withdrawal.getAmount());
    }

    @Test
    public void deposit_should_returns_positive_amount() {
        // WHEN
        Operation withdrawal = new Operation(new Date(), TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(100)));

        // THEN
        Assertions.assertThat(new Money(BigDecimal.valueOf(100))).isEqualTo(withdrawal.getAmount());
    }
}
