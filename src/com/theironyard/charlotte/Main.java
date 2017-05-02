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

        Person p = new Person();

        p.personProject();
    }
}
