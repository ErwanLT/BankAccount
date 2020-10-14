package fr.eletutour.acceptance.stepsDef;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.eletutour.Money;
import fr.eletutour.account.BankAccount;
import fr.eletutour.operation.OperationsHistory;
import fr.eletutour.statement.StatementPrinter;
import org.assertj.core.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountOperationsSteps {
    private BankAccount account;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        OperationsHistory operationsHistory = new OperationsHistory();
        account = new BankAccount(operationsHistory);
        System.setOut(new PrintStream(out));
    }

    @Given("^I deposit (\\d+) euros$")
    public void i_deposit_euros(BigDecimal amount) throws Throwable {
        account.makeDeposit(new Money(amount));
    }

    @Given("^I withdraw (\\d+) euros$")
    public void i_withdraw_euros(BigDecimal amount) throws Throwable {
        account.makeWithdrawal(new Money(amount));
    }

    @When("^I ask for the statement$")
    public void i_ask_for_the_statement() throws Throwable {
        out.reset();
        account.getAccountStatement(new StatementPrinter());
    }

    @Then("^My balance should be (-?\\d+)")
    public void my_balance_should_be_Euros(BigDecimal accountBalance) throws Throwable {
        assertThat(out.toString()).isNotEmpty();
        BigDecimal result = new BigDecimal(out.toString().split("\n")[1].split("\\|")[3].trim()).setScale(1);
        Assertions.assertThat(result).isEqualTo(accountBalance);
    }
}
