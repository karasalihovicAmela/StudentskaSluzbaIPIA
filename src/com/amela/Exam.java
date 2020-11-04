package com.amela;

public class Exam {

    private String id;

    private Subject subject;

    private Date date;

    private Classroom classroom;

    public Exam() {
    }

    public Exam(String id, Subject subject, Date date, Classroom classroom) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.classroom = classroom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
