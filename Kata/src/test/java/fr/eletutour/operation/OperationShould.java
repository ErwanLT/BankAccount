package fr.eletutour.operation;

import fr.eletutour.Money;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OperationShould {

    @Test
    public void be_created_with_negative_amount_for_withdrawal() {
        // WHEN
        Operation withdrawal = new Operation(new Date(), TypeOperation.WITHDRAWAL, new Money(BigDecimal.valueOf(100)));

        // THEN
        Assertions.assertThat(new Money(BigDecimal.valueOf(-100))).isEqualTo(withdrawal.getAmount());
    }

    @Test
    public void be_created_with_positive_amount_for_deposit() {
        // WHEN
        Operation withdrawal = new Operation(new Date(), TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(100)));

        // THEN
        Assertions.assertThat(new Money(BigDecimal.valueOf(100))).isEqualTo(withdrawal.getAmount());
    }
}
