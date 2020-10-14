package fr.eletutour.operation;

import fr.eletutour.Money;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountOperations {

    private List<Operation> operations;


    public AccountOperations(){
        this.operations = new ArrayList<Operation>();
    }

    public void addOperation(TypeOperation typeOperation, Money amount){
        this.operations.add(new Operation(new Date(), typeOperation, amount));
    }
}
