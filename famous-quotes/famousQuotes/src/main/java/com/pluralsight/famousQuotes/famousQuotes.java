package com.pluralsight.famousQuotes;

import java.util.Scanner;

public class famousQuotes {
    static Scanner pScanner = new Scanner(System.in);
    static String[] quotes = {
            "The only limit to our realization of tomorrow is our doubts of today. - Franklin D. Roosevelt",
            "In the end, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King Jr.",
            "Life is what happens when you're busy making other plans. - John Lennon",
            "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill",
            "Do not dwell in the past, do not dream of the future, concentrate the mind on the present moment. - Buddha",
            "You miss 100% of the shots you don't take. - Wayne Gretzky",
            "The journey of a thousand miles begins with one step. - Lao Tzu",
            "That which does not kill us makes us stronger. - Friedrich Nietzsche",
            "The best way to predict the future is to invent it. - Alan Kay",
            "Be yourself; everyone else is already taken. - Oscar Wilde"
    };



    public static void main(String[] args) {
        boolean option= true;
        while(option) {

            try {
                System.out.println("""
                                    \s
                                    Welcome to the Quote Display
                                    \s
                                    Choose a number between 1-10 
                        """);
                int answer = pScanner.nextInt();
                pScanner.nextLine();

                if (answer >=1 && answer <= 10){

                    System.out.println(quotes[answer-1]);

                }else {
                    System.out.println("Invalid input! Please select a number between 1 and 10.");

                }
                System.out.println("Do you want to see another quote? Y/N");
                String index = pScanner.nextLine().trim().toUpperCase();
                if (!index.equals("Y")){
                    option=false;
                    System.out.println("GoodBye!");
                }

            }catch (Exception e){
                System.out.println("Invalid input! Please enter a valid number.");
                pScanner.nextLine();
            }
        }







}
}
