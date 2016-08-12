package com.theironyard.charlotte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, ArrayList<Person>> personHash = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException{
	// write your code here

        File f = new File("people.txt");

        Scanner fileScanner = new Scanner(f);
        ArrayList<Person> arrayPerson = new ArrayList<>();

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split(",");
            Person filePeople = new Person(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);
            arrayPerson.add(filePeople);
            // put if absent add empty arraylist as value of hashmap
            // personHash.put(columns[4], arrayPerson);
            // I think this is storing properly?
            // tried to use .get to print specific "keys" but got one long array
            // could be a problem with the way I am calling
            personHash.putIfAbsent(columns[4], new ArrayList<>());
            personHash.get(columns[4]).add(filePeople);

        }
        System.out.println(personHash);










    }
}
