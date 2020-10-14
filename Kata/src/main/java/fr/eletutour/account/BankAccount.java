package fr.eletutour.account;

import fr.eletutour.Money;
import fr.eletutour.operation.AccountOperations;
import fr.eletutour.operation.TypeOperation;

public class BankAccount {

    private AccountOperations accountOperations;

    public BankAccount(AccountOperations accountOperations) {
        this.accountOperations = accountOperations;
    }

    public void makeDeposit(Money money){
        this.accountOperations.addOperation(TypeOperation.DEPOSIT, money);
    }

    public AccountOperations getAccountOperations(){
        return this.accountOperations;
    }
}
