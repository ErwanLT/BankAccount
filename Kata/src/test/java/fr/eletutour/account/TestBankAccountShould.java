package fr.eletutour.account;

import fr.eletutour.Money;
import fr.eletutour.operation.AccountOperations;
import fr.eletutour.operation.TypeOperation;
import fr.eletutour.statement.StatementPrinter;
import org.junit.Test;
import org.mockito.InOrder;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class TestBankAccountShould {

    @Test
    public void deposit_added_in_account_operations(){
        //Given
        AccountOperations accountOperations = mock(AccountOperations.class);
        BankAccount bankAccount = new BankAccount(accountOperations);

        //When
        bankAccount.makeDeposit(new Money(BigDecimal.valueOf(100)));

        //Then
        verify(accountOperations).addOperation(TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(100)));
    }

    @Test
    public void withdrawal_added_in_account_operations(){
        //Given
        AccountOperations accountOperations = mock(AccountOperations.class);
        BankAccount bankAccount = new BankAccount(accountOperations);

        //When
        bankAccount.makeWithdrawal(new Money(BigDecimal.valueOf(100)));

        //Then
        verify(accountOperations).addOperation(TypeOperation.WITHDRAWAL, new Money(BigDecimal.valueOf(100)));
    }

    @Test
    public void multiple_operation_added_in_account_operations(){
        //Given
        AccountOperations accountOperations = mock(AccountOperations.class);
        BankAccount bankAccount = new BankAccount(accountOperations);

        //When
        bankAccount.makeDeposit(new Money(BigDecimal.valueOf(100)));
        bankAccount.makeWithdrawal(new Money(BigDecimal.valueOf(100)));

        // THEN
        InOrder inOrder = inOrder(accountOperations);
        inOrder.verify(accountOperations).addOperation(TypeOperation.DEPOSIT, new Money(BigDecimal.valueOf(100)));
        inOrder.verify(accountOperations).addOperation(TypeOperation.WITHDRAWAL, new Money(BigDecimal.valueOf(100)));
    }

    @Test
    public void print_statement_from_history() {
        // GIVEN
        AccountOperations accountOperations = mock(AccountOperations.class);
        BankAccount bankAccount = new BankAccount(accountOperations);
        StatementPrinter printer = mock(StatementPrinter.class);

        // WHEN
        bankAccount.getAccountStatement(printer);

        // THEN
        verify(accountOperations).getStatement();
    }
}
