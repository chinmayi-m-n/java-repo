package com.ivoyant.SpringMVCCRUD.Entity;

public class Employee implements Comparable<Employee>{
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Employee o) {
        //if current employee id is greater than other employee id the current employee is greater
        if(this.id>o.id)return 1;
        else if(this.id<o.id)return -1;
        else return 0;
    }
}
