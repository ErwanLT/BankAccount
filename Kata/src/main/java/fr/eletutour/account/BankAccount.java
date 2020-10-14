package fr.eletutour.account;

import fr.eletutour.Money;
import fr.eletutour.operation.OperationsHistory;
import fr.eletutour.operation.TypeOperation;
import fr.eletutour.statement.StatementPrinter;

public class BankAccount {

    private OperationsHistory operationsHistory;

    public BankAccount(OperationsHistory operationsHistory) {
        this.operationsHistory = operationsHistory;
    }

    public void makeDeposit(Money money){
        this.operationsHistory.addOperation(TypeOperation.DEPOSIT, money);
    }

    public void makeWithdrawal(Money money){
        this.operationsHistory.addOperation(TypeOperation.WITHDRAWAL, money);
    }

    public void getAccountStatement(StatementPrinter printer){
        printer.print(operationsHistory.getStatement());
    }

    public OperationsHistory getAccountOperations(){
        return this.operationsHistory;
    }
}
