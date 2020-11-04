package com.amela;

import java.util.ArrayList;

public class Student {

    private String firstName;

    private String lastName;

    private String id;

    private String year;

    private ArrayList<Subject> subjects;

    private ArrayList<Exam> exams;

    public Student() {
    }

    public Student(String firstName, String lastName, String id, String year, ArrayList<Subject> subjects, ArrayList<Exam> exams) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.year = year;
        this.subjects = subjects;
        this.exams = exams;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

}
