package com.amela;

public class Classroom {

    private String id;

    private String name;

    private Integer numSeats;

    public Classroom() {
    }

    public Classroom(String id, String name, Integer numSeats) {
        this.id = id;
        this.name = name;
        this.numSeats = numSeats;
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

    public Integer getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(Integer numSeats) {
        this.numSeats = numSeats;
    }
}
