package com.pluralsight.PayrollCalculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PayRollCalculator {
    public static void main(String[] args) throws IOException {
        Employee b=null;
        System.out.println(System.getProperty("user.dir"));
        String fileName = "./src/main/resources/emplo.csv";
        b= readEmployeeFromFile(fileName);
        System.out.println(b);

    }

    /*
    private static ArrayList <Employee> readAllEmployeesFromFile (String fileName){
        ArrayList<Employee>  employee = new ArrayList<>();
        return employee;
    }

     */

    private static Employee readEmployeeFromFile (String fileName){
        Employee b;
        try(BufferedReader employeeFileReader = openFileReader(fileName)){
            String employeeString = employeeFileReader.readLine();
            String[] employeedata = employeeString.split("\\|");
            //String convert to correct data type
            int employeeID =Integer.parseInt(employeedata[0]);
            String name = employeedata[1];
            double hoursWorked = Double.parseDouble(employeedata[2]);
            double payRate = Double.parseDouble(employeedata[3]);

            b= new Employee(employeeID, name, hoursWorked, payRate);

        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return b;
    }

    private static BufferedReader openFileReader (String fileName) throws FileNotFoundException{
        BufferedReader employeeFileReader;
        employeeFileReader= new BufferedReader(new FileReader(fileName));
        return employeeFileReader;
    }


}
