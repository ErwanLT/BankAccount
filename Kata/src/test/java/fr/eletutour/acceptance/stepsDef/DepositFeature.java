package fr.eletutour.acceptance.stepsDef;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.eletutour.Money;
import fr.eletutour.account.BankAccount;
import fr.eletutour.operation.AccountOperations;

import java.math.BigDecimal;

public class DepositFeature {

    private BankAccount account;

    @Before
    public void init(){
        AccountOperations accountOperations = new AccountOperations();
        account = new BankAccount(accountOperations);
    }

    @Given("^I deposit (\\d+) euros$")
    public void i_deposit_euros(BigDecimal amount) throws Throwable {
        account.makeDeposit(new Money(amount));
    }
}
