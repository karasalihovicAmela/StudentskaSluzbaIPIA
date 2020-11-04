package com.amela;

import java.util.ArrayList;

public class Tutor {

    private String firstName;

    private String lastName;

    private String id;

    private ArrayList<Subject> subjects;

    public Tutor() {
    }

    public Tutor(String firstName, String lastName, String id, ArrayList<Subject> subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.subjects = subjects;
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

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
}
