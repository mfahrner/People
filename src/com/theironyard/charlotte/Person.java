package com.theironyard.charlotte;

/**
 * Created by mfahrner on 8/11/16.
 */
public class Person implements Comparable {
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

     public int compareTo(Object o) {
        Person p = (Person) o;
         return lName.compareTo(p.lName);
     }
}


