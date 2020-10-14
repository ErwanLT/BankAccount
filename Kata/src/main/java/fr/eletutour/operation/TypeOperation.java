package fr.eletutour.operation;

public enum TypeOperation {
    DEPOSIT("deposit"), WITHDRAWAL("withdrawal");

    private String name;

    TypeOperation(String name){
        this.name = name;
    }
}
