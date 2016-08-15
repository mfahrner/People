package com.theironyard.charlotte;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, ArrayList<Person>> personHashMap = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException{

        File f = new File("people.txt");

        Scanner fileScanner = new Scanner(f);

        while (fileScanner.hasNext()) {

            String line = fileScanner.nextLine();
            String[] columns = line.split(",");

            // I tried to use commented out lines below to refactor the input lines on 26,27
            // and creating Person object
            // I couldn't figure out how to get them to work together.
            // Conceptually i believe the columns are tripping me up

            // Person.inputFile(fileScanner.nextLine());
            // Person.createPerson(columns);

            personHashMap.putIfAbsent(columns[4], new ArrayList<>());

            personHashMap.get(columns[4]).add(Person.createPerson(columns));

            Collections.sort(personHashMap.get(columns[4]));
        }

        // I dont understand the need for the try catch block here when the method signature declares throws exception
        try {
            Person.saveJson(personHashMap);
        } catch (IOException e) {

        }
        System.out.println(personHashMap);
    }
}
