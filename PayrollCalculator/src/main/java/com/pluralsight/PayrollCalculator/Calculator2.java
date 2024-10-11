package com.pluralsight.PayrollCalculator;

import java.io.*;
import java.util.ArrayList;

public class Calculator2 {
    public static void main(String[] args) throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();
        String fileName = "./src/main/resources/emplo.csv";
        String outputFile = "./src/main/resources/employeeGrossPay.csv";
        employees = readEmployeeFromFile(fileName);
        writeEmployeeInFile(outputFile, employees);
        for (Employee employee: employees){
            System.out.println(employee);
        }

    }

    /*
    private static ArrayList <Employee> readAllEmployeesFromFile (String fileName){
        ArrayList<Employee>  employee = new ArrayList<>();
        return employee;
    }

     */



    private static ArrayList<Employee> readEmployeeFromFile (String fileName) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        try (BufferedReader employeeFileReader = openFileReader(fileName)) {
            String employeeString;
            while ((employeeString = employeeFileReader.readLine()) != null) {
                String[] employeeData = employeeString.split("\\|");
                int employeeID = Integer.parseInt(employeeData[0]);
                String name = employeeData[1];
                double hoursWorked = Double.parseDouble(employeeData[2]);
                double payRate = Double.parseDouble(employeeData[3]);
                employeeList.add(new Employee(employeeID, name, hoursWorked, payRate));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }



    private static void writeEmployeeInFile (String fileName, ArrayList<Employee> employees) {
        try (BufferedWriter bufwriter = openFileWritter(fileName)) {
            for (Employee employee : employees) {
                String output = String.format("""
                                %d|%s|%.2f\n
                                """,employee.getEmployeeID(), employee.getName(), employee.getGrossPay()






                );
                bufwriter.write(output);
            }
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }

    }

    private static BufferedReader openFileReader (String fileName) throws FileNotFoundException {
        BufferedReader employeeFileReader;
        employeeFileReader= new BufferedReader(new FileReader(fileName));
        return  employeeFileReader;
    }

    private static BufferedWriter openFileWritter (String outputFile) throws IOException {
        BufferedWriter employeeFileWritter;
        employeeFileWritter = new BufferedWriter(new FileWriter(outputFile));
        return employeeFileWritter;
    }





}
