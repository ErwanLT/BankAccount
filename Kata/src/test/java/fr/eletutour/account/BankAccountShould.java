package fr.eletutour.account;

import fr.eletutour.Money;
import fr.eletutour.operation.OperationsHistory;
import fr.eletutour.operation.TypeOperation;
import fr.eletutour.statement.StatementPrinter;
import org.junit.Test;
import org.mockito.InOrder;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class BankAccountShould {

    @Test
    public void making_deposit_should_add_operation_in_account_operations_history(){
        //Given
        OperationsHistory operationsHistory = mock(OperationsHistory.class);
        BankAccount bankAccount = new BankAccount(operationsHistory);

        //When
        bankAccount.makeDeposit(new Money(BigDecimal.valueOf(100)));

        //Then
        verify(operationsHistory).addOperation(TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(100)));
    }

    @Test
    public void making_withdraw_should_add_operation_in_account_operations_history(){
        //Given
        OperationsHistory operationsHistory = mock(OperationsHistory.class);
        BankAccount bankAccount = new BankAccount(operationsHistory);

        //When
        bankAccount.makeWithdrawal(new Money(BigDecimal.valueOf(100)));

        //Then
        verify(operationsHistory).addOperation(TypeOperation.WITHDRAWAL, new Money(BigDecimal.valueOf(100)));
    }

    @Test
    public void making_multiple_operation_should_be_added_in_account_operations_history(){
        //Given
        OperationsHistory operationsHistory = mock(OperationsHistory.class);
        BankAccount bankAccount = new BankAccount(operationsHistory);

        //When
        bankAccount.makeDeposit(new Money(BigDecimal.valueOf(100)));
        bankAccount.makeWithdrawal(new Money(BigDecimal.valueOf(100)));

        // THEN
        InOrder inOrder = inOrder(operationsHistory);
        inOrder.verify(operationsHistory).addOperation(TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(100)));
        inOrder.verify(operationsHistory).addOperation(TypeOperation.WITHDRAWAL, new Money(BigDecimal.valueOf(100)));
    }

    @Test
    public void print_statement_from_history() {
        // GIVEN
        OperationsHistory operationsHistory = mock(OperationsHistory.class);
        BankAccount bankAccount = new BankAccount(operationsHistory);
        StatementPrinter printer = mock(StatementPrinter.class);

        // WHEN
        bankAccount.getAccountStatement(printer);

        // THEN
        verify(operationsHistory).getStatement();
    }
}
