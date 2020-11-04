package com.amela;

public class Subject {

    private String id;

    private String name;

    private String year;

    private Tutor tutor;

    public Subject() {
    }

    public Subject(String id, String name, String year, Tutor tutor) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.tutor = tutor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
