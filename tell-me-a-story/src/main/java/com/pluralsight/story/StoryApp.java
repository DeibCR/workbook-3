package com.pluralsight.story;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StoryApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner pScanner = new Scanner(System.in);


        boolean option = true;

        while (option) {


            System.out.println("""
                                \s
                                What story would yoiu like to read?
                                1. Goldilocks
                                2. Hanzel and Gretel
                                3. Mary Had a little lamp
                    """);
            option = false;

        }
        int count = pScanner.nextInt();
        pScanner.nextLine();

        switch (count) {
            case 1:
                readFile("Goldilocks.txt");
            case 2:
                readFile("hansel_and_gretel.txt");
            case 3:
                readFile("mary_had_a_little_lamb.txt");
        }

    }

    private static void readFile(String filename) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("./src/main/resources/" + filename);
        Scanner fileScanner = new Scanner(fis);
        while (fileScanner.hasNextLine()) {
            String input = fileScanner.nextLine();
            System.out.println(input);
        }
        fileScanner.close();

    }
}
