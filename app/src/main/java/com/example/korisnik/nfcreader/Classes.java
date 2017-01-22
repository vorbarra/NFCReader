package com.example.korisnik.nfcreader;

import java.util.HashMap;

/**
 * Created by Korisnik on 21.1.2017..
 */

public class Classes {
    private String ID;
    private String name;
    private HashMap<String, Student> students;

    public Classes() {
        // Default constructor required for calls to DataSnapshot.getValue(Classes.class)
    }

    public Classes(String ID, String name, HashMap<String, Student> students){
        this.ID = ID;
        this.name = name;
        this.students = students;
    }

}
