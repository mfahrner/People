package com.theironyard.charlotte;

/**
 * Created by mfahrner on 8/11/16.
 */
public class Person {
    String id;
    String fName;
    String lName;
    String email;
    String country;
    String ip;

    public Person(String id, String fName, String lName, String email, String country, String ip) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.country = country;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return String.format("%s %s from %s\n", fName, lName, country);
    }

    // public int compareTo(Object o) {
       // Person p = (Person) o;
        // return lName.compareTo(p.lName);
    // }
    // id,first_name,last_name,email,country,ip_address
}


