package com.pluralsight.famousQuotes;

import java.util.Scanner;

public class famousQuotes {
    static Scanner pScanner = new Scanner(System.in);

    public static void main(String[] args) {



        try {
            String[] quotes = {
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

            System.out.println(" Select a number between 1 and 10");
            int index = pScanner.nextInt();
            index--;

            System.out.println(quotes[index]);



        }catch (Exception e){
            System.out.println("Your number was out of range!");
            e.printStackTrace();

        }



}
}
