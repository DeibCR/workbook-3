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
    static ArrayList<Product> cart = new ArrayList<>();


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
                    =================================
                       Welcome to the Online Store
                    =================================
                          Please select an option
                           1- Display Products
                           2- Display Cart
                           3- Exit
                    =================================
                    """);
            int option = mainScanner.nextInt(); //Process the selected option
           // mainScanner.nextLine();

            switch (option) {
                case 1:
                    products = readProductFromFile(fileInput); // Call to the method that read a file with the products
                    displayProducts(products); //Display list of products using a method
                    mainScanner.nextLine(); // next line
                    productsScreenMenu(); // Open a new menu when the user can select to search for a product or filter

                    break;
                case 2:
                    displayCart();
                    removeItemFromCart();
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

    //Display products
    private static void displayProducts(ArrayList<Product> products) {
        System.out.printf("%-10s %-35s %-10s %-20s%n", "SKU", "Product Name", "Price", "Department");
        System.out.println("---------------------------------------------------------------");

        for (Product product : products) {
            System.out.printf("%-10s %-35s $%-9.2f %-20s%n", product.getSku(), product.getProductName(), product.getPrice(), product.getDepartment());
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("Total Products: " + products.size());
    }




    //  Products Screen, that call search methods
    private static void productsScreenMenu() {
        boolean counter = true;
        while (counter) {
            System.out.println("""
                     =================================
                               Products Menu
                     =================================
                     Please select an option
                     1- Search Product
                     2- Sort Product
                     3- Go back
                     =================================
                    """);
            int option = mainScanner.nextInt();
           // mainScanner.nextLine();

            switch (option) {
                case 1:
                    searchMenu();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Main Menu");
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
        while (opt) {
            System.out.println("""
                    =================================
                              Search Menu
                    =================================
                    Please select an option
                    1- Search by Name
                    2- Search by Price
                    3- Search by Department
                    4- Go Back
                    """);
            int option = mainScanner.nextInt();
            mainScanner.nextLine();

            switch (option) {
                case 1:
                    promptSearchName();
                    break;
                case 2:
                    promptSearchPrice();
                    break;
                case 3:
                    promptSearchDepartment();
                    break;
                case 4:
                    System.out.println("Products Menu!");
                    opt = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }


        }
    }
    // Search and promptSearch  methods

    public static void promptSearchName() {
        System.out.println("Enter the name of the product or type 'X' to go back :");

        String name = mainScanner.nextLine().trim(); // Trim and trailing spaces

        if (!name.equalsIgnoreCase("X")) {

            String normalizeInputName = name.toLowerCase(); //Normalize to lowercase search

            ArrayList<Product> matchingProductsName = findProductByName(normalizeInputName);
            if (!matchingProductsName.isEmpty()) {
                System.out.println(" Products found:");
                for (Product product : matchingProductsName) {
                    displayProducts(matchingProductsName);
                    addToCartPrompt(product);

                }
            } else {
                System.out.println("No products found");
            }
        } else {
            System.out.println("Returning to the search menu");
        }
    }

    public static void promptSearchPrice() {
        System.out.println("Enter the price of the product (00.00) or type 'X' to go back :");
        String input = mainScanner.nextLine();

        if (!input.equalsIgnoreCase("X")) {
            try {
                double price = Double.parseDouble(input);
                Product product = findProductByPrice(price);
                if (product != null) {
                    System.out.println("Product found: " + product);



                    addToCartPrompt(product);
                } else {
                    System.out.println("Product not found");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price entered.Plearse try again with the correct format");
            }
        } else {
            System.out.println("Returning");
        }

    }

    public static void promptSearchDepartment() {
        System.out.println("Enter the department of the product or type 'X' to go back :");
        ;
        String department = mainScanner.nextLine().trim(); // Trim and trailing spaces

        if (!department.equalsIgnoreCase("X")) {
            String normalizeInputName = department.toLowerCase(); //Normalize to lowercase search

            ArrayList<Product> matchingProductsDepartment = findProductByDepartment(normalizeInputName);
            if (!matchingProductsDepartment.isEmpty()) {
                System.out.println("Product found:");
                for (Product product : matchingProductsDepartment) {
                    displayProducts(matchingProductsDepartment);

                    addToCartPrompt(product);
                }
            } else {
                System.out.println("Product not found");
            }
        } else {
            System.out.println(" Returning");
        }
    }

    // Search by Name with some matching case
    private static ArrayList<Product> findProductByName(String productName) {
        ArrayList<Product> matchingProductsName = new ArrayList<>(); // temporal array that holds all the matching options
        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(productName)) { //Normalize product name and compare with input
                matchingProductsName.add(product);

            }
        }
        return matchingProductsName;
    }

    // Search by Price
    private static Product findProductByPrice(Double price) {
        for (Product product : products) {
            if (product.getPrice() == price) {
                return product;
            }
        }
        return null;
    }

    // Search by Department
    private static ArrayList<Product> findProductByDepartment(String department) {
        ArrayList<Product> matchingProductsDepartment = new ArrayList<>();// temporal array that holds all the matching options

        for (Product product : products) {
            if (product.getDepartment().toLowerCase().contains(department)) {//Normalize product name and compare with input
                matchingProductsDepartment.add(product);
            }
        }
        return matchingProductsDepartment;
    }


    //Display cart


    private static void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            displayProducts(cart);
        }
    }

    // Add product to cart prompt
    public static void addToCartPrompt(Product product) {
        System.out.println("Would you like to add this product to your cart? (Y/N)");
        String input = mainScanner.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            cart.add(product);
            System.out.println("Product added to cart: " + product.getProductName());
        } else {
            System.out.println("Product not added to cart.");
        }
    }

    //Remove items from cart
    private static void removeItemFromCart(){
        System.out.println("""
                =================================
                           Remove Item Menu
                =================================
                Please select an option:
                1- Remove by Name
                2- Remove by Price
                3- Remove by Department
                4- Go Back
                =================================
                """);
        int option = mainScanner.nextInt();
        //mainScanner.nextLine();

        switch (option) {
            case 1:
                removeByName();
                break;
            case 2:
                removeByPrice();
                break;
            case 3:
                removeByDepartment();
                break;
            case 4:
                System.out.println("Returning to cart...");
                return;
            default:
                System.out.println("Invalid option. Please choose 1, 2, 3, or 4.");
        }
    }

    //Remove by name
    private static void removeByName(){
        System.out.println("Enter the name of the product to remove:");
        String name= mainScanner.nextLine().trim().toLowerCase();

        cart.removeIf(product -> product.getProductName().toLowerCase().contains(name));
        System.out.println("Product(s) removed by name: " + name);
    }

    //Remove by price
    private static void removeByPrice(){
        System.out.println("Enter the name of the product (00.00) to remove:");
        double price = mainScanner.nextDouble();

        cart.removeIf(product -> product.getPrice()==price);
        System.out.println("Product(s) removed by price: $" + price);
    }

    //Remove by department
    private static void removeByDepartment(){
        System.out.println("Enter the department of the product to remove:");
        String department = mainScanner.nextLine().trim().toLowerCase();

        cart.removeIf(product -> product.getDepartment().toLowerCase().contains(department));
        System.out.println("Product(s) removed by department: " + department);
    }




}
