package com.amela;

import java.util.ArrayList;

public class Database {

    private ArrayList<Student> students = new ArrayList<>();

    private ArrayList<Subject> subjects = new ArrayList<>();

    private ArrayList<Tutor> tutors = new ArrayList<>();

    private ArrayList<Exam> exams = new ArrayList<>();

    private ArrayList<Classroom> classrooms = new ArrayList<>();

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setTutors(ArrayList<Tutor> tutors) {
        this.tutors = tutors;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    public void setClassrooms(ArrayList<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public ArrayList<Tutor> getTutors() {
        return tutors;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }


    //U OVOJ METODI CEMO DODATI STUDENTE, PROFESORE, PREDMETE, ISPITE, UCIONICE I DATUME KOJI CE SE PO DEFAULT-U POJAVLJIVATI U LISTAMA
    public void addEverything() {

        Date date = new Date("6.10", "12:00");
        Date date1 = new Date("7.10", "10:00");

        Classroom classroom = new Classroom("CR0", "Racunarski centar", 15);
        Classroom classroom1 = new Classroom("CR1", "Ucionica 1", 20);
        classrooms.add(classroom);
        classrooms.add(classroom1);

        Tutor tutor = new Tutor("Jasenko", "Topic", "PROF0", subjects);
        Tutor tutor1 = new Tutor("Goran", "Madzarevic", "PROF1", subjects);
        tutors.add(tutor);
        tutors.add(tutor1);

        Subject subject = new Subject("SUB0", "Baze podataka", "2", tutor);
        Subject subject1 = new Subject("SUB1", "Programiranje u javi", "3", tutor);
        Subject subject2 = new Subject("SUB2", "Osnove programiranja", "1", tutor1);
        Subject subject3 = new Subject("SUB3", "Objektno programiranje", "2", tutor1);
        subjects.add(subject);
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        Exam exam = new Exam("EXAM0", subject, date, classroom1);
        Exam exam1 = new Exam("EXAM1", subject3, date1, classroom);
        Exam exam2 = new Exam("EXAM2", subject1, date, classroom1);
        Exam exam3 = new Exam("EXAM3", subject2, date1, classroom);
        exams.add(exam);
        exams.add(exam1);
        exams.add(exam2);
        exams.add(exam3);

        ArrayList<Exam> studentExam = new ArrayList<>();
        ArrayList<Subject> studentSubject = new ArrayList<>();
        studentExam.add(exam);
        studentExam.add(exam1);
        studentSubject.add(subject);
        studentSubject.add(subject3);

        Student student = new Student("Nedzib", "Jusic", "STU1", "2", studentSubject, studentExam);
        students.add(student);

        studentExam = new ArrayList<>();
        studentSubject = new ArrayList<>();
        studentExam.add(exam2);
        studentSubject.add(subject1);
        studentSubject.add(subject);

        Student student1 = new Student("Tarik", "Mehmedovic", "STU0", "3", studentSubject, studentExam);
        students.add(student1);

    }

}
