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

/**
 * Created by mfahrner on 8/11/16.
 */
public class Person implements Comparable  {

    private static Scanner fileScanner;
    private String id;
    private String fName;
    private String lName;
    private String email;
    private String country;
    private String ip;



    public void personProject() throws FileNotFoundException {
        File f = new File("people.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {

            String line = fileScanner.nextLine();
            String[] columns = line.split(",");

            Main.personHashMap.putIfAbsent(columns[4], new ArrayList<>());

            Main.personHashMap.get(columns[4]).add(createPerson(columns));

            Collections.sort(Main.personHashMap.get(columns[4]));
        }
        try {
            saveJson(Main.personHashMap);
        } catch (IOException e) {
            System.err.println();
        }
        System.out.println(Main.personHashMap);
    }

    public Person createPerson(String[] columns) {
        return new Person(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);
    }



    public void saveJson(HashMap <String, ArrayList<Person>> personHashMap) throws IOException {

        JsonSerializer serializer = new JsonSerializer();
        String jsonString = serializer.include("*").serialize(personHashMap);


        File fjson = new File("people.json");

        FileWriter fw = new FileWriter(fjson);

        fw.write(jsonString);
        fw.close();
    }

    public Person() {
    }

    public Person(String id, String fName, String lName, String email, String country, String ip) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.country = country;
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return String.format("%s %s from %s\n", fName, lName, country);
    }


    @Override
     public int compareTo(Object o) {
        Person p = (Person) o;
         return lName.compareTo(p.lName);
     }
}


