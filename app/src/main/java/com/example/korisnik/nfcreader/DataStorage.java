package com.example.korisnik.nfcreader;

import java.util.HashMap;

/**
 * Created by Korisnik on 21.1.2017..
 */

public class DataStorage {

    private static String[] classesId = {"FESB01", "FESB02", "FESB03", "FESB04", "FESB05",
            "FESB06"};

    private static String[] classes = {"Programiranje", "Objektno orijentirano programiranje",
    "Algoritmi", "Ugradbeni računalni sustavi", "Multimedijski sustavi", "Mrežni i mobilni OS"};

    private static  String[] studentId = {"72AC5612", "72AC563D", "72865A12", "23AC5612", "D3AC5652"};

    private static String[] studentNames = {"Ivo Ivic", "Mate Matic", "Iva Ivic", "Petar Petrovic", "Maja Majic"};

    public static HashMap<String, Classes> listClasses = new HashMap<String, Classes>();
    public static HashMap<String, Student> listStudent = new HashMap<String, Student>();

    public static void fillData() {
        for(int i = 0; i < classesId.length; i++){
            Student aStudent = new Student(studentId[i],studentNames[i]);
            listStudent.put(studentId[i], aStudent);
        }

        for(int i = 0; i < classesId.length; i++){
            Classes aClass = new Classes(classesId[i],classes[i],listStudent);
            listClasses.put(classesId[i], aClass);
        }
    }
}
