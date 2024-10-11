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

    //Home screen

    private static void homeScreen() {

        boolean keepCount = true;
        while (keepCount) {
            System.out.println("""
                             Welcome to the Online Store
                           (Please type the option you want to access)
                           1. Display Products
                           2. Display Cart
                           3. Exit \s
                    
                    \s""");
            int option = mainScanner.nextInt();
            mainScanner.nextLine();

            switch (option) {
                case 1:
                    products=readProductFromFile(fileInput);
                    for (Product product: products){
                        System.out.println(product);

                    }
                    mainScanner.nextLine();

                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Exiting the Online Store");
                    keepCount = false;
                    break;
                default:
                   System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }





    }


}
