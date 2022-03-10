package be.intec.model;

public class Employee {
//    making setters return this (instance of class) allows you to fill yhe properties you wish (see main for example)

    private String name;
    private String familyName;

    // the kind of methods are called builder-patterns (design pattern).
    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Employee setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }
}
