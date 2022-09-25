package org.avol.jdk15.record;

//setters & getters typical Immutable pojo clas in java prior to v15.
public class EmpPojo {

    private final String name;
    private final String id;
    private final Float salary;

    public EmpPojo(String name, String id, Float salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public Float getSalary() {
        return salary;
    }
}
