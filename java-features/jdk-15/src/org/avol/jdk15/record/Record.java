package org.avol.jdk15.record;

public class Record {

    public static void main(String[] args) {

        EmpPojo empPojo = new EmpPojo("James", "123", 40500.45f);
        System.out.println("EmpPojo#salary: " + empPojo.getSalary());
        EmpRecord empRecord = new EmpRecord("James", "123", 40500.45f);
        System.out.println("EmpRecord#salary: " + empRecord.salary());

    }
}
