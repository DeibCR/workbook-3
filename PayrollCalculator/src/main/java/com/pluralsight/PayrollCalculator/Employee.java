package com.pluralsight.PayrollCalculator;

public class Employee {
    int employeeID;
    String name;
    double hoursWorked;
    double payRate;

    public Employee(int employeeID, String name, double hoursWorked, double payRate) {
        this.employeeID = employeeID;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return this.hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return this.payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getGrossPay() {
        return this.hoursWorked * this.payRate;
    }

    public String toString() {
        return "Employee{ID= " + this.employeeID + ",Name ='" + this.name + "',Worked Hours:=" + this.hoursWorked + ", payRate=" + this.payRate + "}";
    }
}
