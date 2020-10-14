package fr.eletutour.operation;

import fr.eletutour.Money;
import fr.eletutour.statement.StatementLine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AccountOperations {

    private List<Operation> operations;


    public AccountOperations(){
        this.operations = new ArrayList<>();
    }

    public void addOperation(TypeOperation typeOperation, Money amount){
        this.operations.add(new Operation(new Date(), typeOperation, amount));
    }

    public List<StatementLine> getStatement() {
        List<StatementLine> statement = new ArrayList<>();
        Money balance = new Money(BigDecimal.valueOf(0));
        for (Operation operation : this.operations) {
            balance = balance.add(operation.getAmount());
            statement.add(new StatementLine(operation, balance));
        }
        Collections.reverse(statement);
        return statement;
    }
}
