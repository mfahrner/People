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

    public static HashMap<String, ArrayList<Person>> personHash = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException{
	// write your code here

        File f = new File("people.txt");
        File fjson = new File("people.json");

        Scanner fileScanner = new Scanner(f);


        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split(",");
            Person filePeople = new Person(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);
            personHash.putIfAbsent(columns[4], new ArrayList<>());
            personHash.get(columns[4]).add(filePeople);
            Collections.sort(personHash.get(columns[4]));
        }

        // write Json
        JsonSerializer serializer = new JsonSerializer();
        String jsonString = serializer.serialize(personHash);
        try {
            FileWriter fw = new FileWriter(fjson);
            fw.write(jsonString);
            fw.close();
        } catch (IOException e) {

        }
        
        System.out.println(personHash);










    }
}
