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
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getGrossPay(){
        return hoursWorked*payRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "ID= " + employeeID +
               ",Name ='" + name + '\'' +
               ",Worked Hours:=" + hoursWorked +
               ", payRate=" + payRate +
               '}';
    }
}
