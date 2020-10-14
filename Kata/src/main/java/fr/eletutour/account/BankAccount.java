package fr.eletutour.account;

import fr.eletutour.Money;
import fr.eletutour.operation.AccountOperations;
import fr.eletutour.operation.TypeOperation;
import fr.eletutour.statement.StatementPrinter;

public class BankAccount {

    private AccountOperations accountOperations;

    public BankAccount(AccountOperations accountOperations) {
        this.accountOperations = accountOperations;
    }

    public void makeDeposit(Money money){
        this.accountOperations.addOperation(TypeOperation.DEPOSIT, money);
    }

    public void makeWithdrawal(Money money){
        this.accountOperations.addOperation(TypeOperation.WITHDRAWAL, money);
    }

    public void getAccountStatement(StatementPrinter printer){
        printer.print(accountOperations.getStatement());
    }

    public AccountOperations getAccountOperations(){
        return this.accountOperations;
    }
}
