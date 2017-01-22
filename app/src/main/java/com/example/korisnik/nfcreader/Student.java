package com.example.korisnik.nfcreader;

/**
 * Created by Korisnik on 21.1.2017..
 */

public class Student {
    private String ID;
    private String name;
    private int eviden = 0;

    public Student(String ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public Student() {
        // Default constructor required for calls to DataSnapshot.getValue(Classes.class)
    }
}
