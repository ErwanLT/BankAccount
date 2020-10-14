package fr.eletutour.operation;

import fr.eletutour.Money;

import java.util.Date;
import java.util.Objects;

public class Operation {
    private Date createdOn;

    private TypeOperation typeOperation;

    private Money amount;

    public Operation(Date date, TypeOperation typeOperation, Money amount) {
        this.createdOn = date;
        this.typeOperation = typeOperation;
        if (typeOperation == TypeOperation.WITHDRAWAL) {
            this.amount = amount.negate();
        } else {
            this.amount = amount;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(typeOperation, operation.typeOperation)
                && Objects.equals(amount, operation.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdOn, typeOperation, amount);
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public Money getAmount() {
        return amount;
    }
}
