package com.pluralsight.OnlineStore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStore {
    static Scanner mainScanner = new Scanner(System.in);
    static String fileInput = "./src/main/resources/products.csv";
    static ArrayList<Product> products = new ArrayList<>();
    static  ArrayList<Product> cart = new ArrayList<>();


    public static void main(String[] args) {
        homeScreen();


    }


    //readers  methods

    private static BufferedReader openFileReader(String fileInput) throws FileNotFoundException {
        BufferedReader productFileReader;
        productFileReader = new BufferedReader(new FileReader(fileInput));
        return productFileReader;
    }

    private static ArrayList<Product> readProductFromFile(String fileInput) {
        Product b;
        ArrayList<Product> productList = new ArrayList<>();
        try (BufferedReader productFileReader = openFileReader(fileInput)) {
            String productString;
            productFileReader.readLine();
            while ((productString = productFileReader.readLine()) != null) {
                String[] productData = productString.split("\\|");
                String sku = productData[0];
                String productName = productData[1];
                double price = Double.parseDouble(productData[2]);
                String department = productData[3];
                productList.add(new Product(sku, productName, price, department));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    //Home screen method, that call other methods

    private static void homeScreen() {

        boolean keepCount = true;
        while (keepCount) {
            System.out.println("""
                             Welcome to the Online Store
                           (Please type the option you want to access)
                           1- Display Products
                           2- Display Cart
                           3- Exit \s
                    \s""");
            int option = mainScanner.nextInt();
            mainScanner.nextLine();

            switch (option) {
                case 1:
                    products = readProductFromFile(fileInput); // Csll to the method that read a file with the productss
                    for (Product product : products) {
                        System.out.println(product);// display a list of products

                    }
                    mainScanner.nextLine();

                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Exiting the Online Store, Thank you!");
                    keepCount = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }

    }
    // Display Products Screen, that call search methods
    private static void productsMenu() {
        boolean counter = true;
        while (counter){
            System.out.println("""
                           (Please type the option you want to access)
                           1- Search Product
                           2- Filter Product
                           3- Go back\s
                    \s""");
            int option= mainScanner.nextInt();
            mainScanner.nextLine();

            switch  (option) {
                case 1:




                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Exiting the Online Store, Thank you!");
                    counter = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }


        }


    }

    //Search menu

    public static void searchMenu() {
        boolean opt = true;
        while (opt){
            System.out.println("""
                           (Please type the option you want to access)
                           1- Search by Name
                           2- Search by Price
                           3- Search by Department
                           4- Go back\s
                    \s""");
            int option= mainScanner.nextInt();
            mainScanner.nextLine();

            switch  (option) {
                case 1:






                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Exiting the Online Store, Thank you!");
                    opt = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }


        }
    }






    // Search methods

    public static void prompSearchName(){
        System.out.println("Enter the name of the product or type 'X' to go back:");;
        String type = mainScanner.nextLine();


    }

    // Search by Name
    private static Product findProducByName(String productName) {
        for (Product product : products) {
            if (product.getProductName() == productName) {
                return product;
            }
        }
        return null;
    }

    // Search by Price
    private static Product findProducByPrice(Double price) {
        for (Product product : products) {
            if (product.getPrice() == price) {
                return product;
            }
        }
        return null;
    }

    // Search by Department
    private static Product findProducByDep(String department) {
        for (Product product : products) {
            if (product.getDepartment() == department) {
                return product;
            }
        }
        return null;
    }


}
