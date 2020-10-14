package fr.eletutour.operation;

import fr.eletutour.Money;
import fr.eletutour.statement.StatementLine;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OperationsHistoryShould {

    @Test
    public void adding_deposit_of_100_should_create_an_operation_and_be_visible_in_statement(){
        // GIVEN
        OperationsHistory history = new OperationsHistory();

        // WHEN
        history.addOperation(TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(100)));

        // THEN
        StatementLine expected = new StatementLine(new Operation(new Date(), TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(100))), new Money(BigDecimal.valueOf(100)));
        Assertions.assertThat(history.getStatement().get(0)).isEqualTo(expected);
    }

    @Test
    public void generate_a_statement_from_operations_history() {
        // GIVEN
        OperationsHistory history = new OperationsHistory();

        // WHEN
        history.addOperation(TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(100)));
        history.addOperation(TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(200)));

        // THEN
        List<StatementLine> statementLines = new ArrayList<>();
        statementLines.add(new StatementLine(new Operation(new Date(), TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(100))), new Money(BigDecimal.valueOf(100))));
        statementLines.add(new StatementLine(new Operation(new Date(), TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(100))), new Money(BigDecimal.valueOf(200))));

        // WHEN
        List<StatementLine> result = history.getStatement();
        Assertions.assertThat(result).hasSize(2);
    }
}
