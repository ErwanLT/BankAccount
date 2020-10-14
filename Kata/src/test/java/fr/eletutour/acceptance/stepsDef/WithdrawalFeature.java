package fr.eletutour.acceptance.stepsDef;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import fr.eletutour.Money;
import fr.eletutour.account.BankAccount;
import fr.eletutour.operation.AccountOperations;

import java.math.BigDecimal;

public class WithdrawalFeature {

    private BankAccount account;

    @Before
    public void init(){
        AccountOperations accountOperations = new AccountOperations();
        account = new BankAccount(accountOperations);
    }

    @Given("^I withdraw (\\d+) euros$")
    public void i_deposit_euros(BigDecimal amount) throws Throwable {
        account.makeWithdrawal(new Money(amount));
    }
}
