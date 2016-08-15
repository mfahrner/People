package com.theironyard.charlotte;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, ArrayList<Person>> personHashMap = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException{
	// write your code here

        File f = new File("people.txt");

        Scanner fileScanner = new Scanner(f);

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split(",");
            // Person.inputFile(fileScanner.nextLine());
            Person filePeople = new Person(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);
            personHashMap.putIfAbsent(columns[4], new ArrayList<>());
            personHashMap.get(columns[4]).add(filePeople);
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
