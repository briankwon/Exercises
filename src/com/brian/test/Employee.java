package com.brian.test;

public class Employee extends Person {
    private int id;

    public Employee(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Employee employee = (Employee) obj;
            if (employee.getId() <= 0 || id <= 0) {
                return false;
            } else {
                return super.equals(obj) && employee.getId() == this.id;
            }
        }

        return super.equals(obj);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
