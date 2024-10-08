package com.pluralsight.story;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StoryApp {
    public static void main(String[] args) {


        FileInputStream fis=null;
        try{


         fis = new FileInputStream("./src/main/resources/goldilocks.txt");
    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner fileScanner = new Scanner(fis);

        while(fileScanner.hasNextLine()){
            String input = fileScanner.nextLine();
            System.out.println(input);
        }
    }
}
