package com.amela;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //VARIJABLE KOJE MOGU KORISTIT U SVIM FUNKCIJAMA
    public static Scanner scanner = new Scanner(System.in);
    public static Database database = new Database();

    public static void main(String[] args) {

        database.addEverything();

        boolean quitAll = false;
        int choice = 0;
        while (!quitAll) {
            //GLAVNI MENI
            System.out.println("Odaberite entitet nad kojim zelite radite izmjene:" +
                    "\n0) Izlaz" +
                    "\n1) Student" +
                    "\n2) Profesor" +
                    "\n3) Predmeti" +
                    "\n4) Ispit" +
                    "\nUnesite broj: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    quitAll = true;
                    break;
                case 1:
                    //STUDENT
                    int choiceStudent = -1;

                    boolean quit = false;

                    while (!quit) {
                        //STUDENT MENI
                        System.out.println("\nSTUDENT" +
                                "\nIzaberite operaciju: " +
                                "\n0) Izlaz" +
                                "\n1) Dodavanje studenta" +
                                "\n2) Brisanje studenta" +
                                "\n3) Ispis studenata" +
                                "\n4) Ispis studenata po godini" +
                                "\n5) Ispis studenata po predmetu");
                        choiceStudent = scanner.nextInt();
                        switch (choiceStudent) {
                            case 0:
                                quit = true;
                                break;
                            //UNOS STUDENTA
                            case 1:
                                System.out.println("UNOS STUDENTA: ");
                                Student student = new Student();

                                System.out.println("Unesite ime: ");
                                String studentName = scanner.next();

                                System.out.println("Unesite prezime: ");
                                String studentLastName = scanner.next();

                                System.out.println("Unesite godinu: ");
                                String studentYear = scanner.next();

                                System.out.println("Unesite ID predmeta koje zelite dodijeliti studentu (nula prekida unos): ");
                                String enterSub = "-1";
                                ArrayList<Subject> studSub = new ArrayList<>();
                                for(Subject s: database.getSubjects())
                                    System.out.println(s.getName() + " | " + s.getId() + " | " + s.getTutor().getFirstName() + " | " + s.getTutor().getLastName());
                                while(!enterSub.equals("0")){
                                    enterSub = scanner.next().toUpperCase();
                                    Subject addSub = getSubjectData(enterSub);
                                    studSub.add(addSub);
                                }

                                System.out.println("Unesite ID ispita koje zelite dodijeliti studentu (nula prekida unos): ");
                                String enterExam = "-1";
                                ArrayList<Exam> studExam = new ArrayList<>();
                                for(Exam e: database.getExams())
                                    System.out.println(e.getSubject().getName() + " | " + e.getId());
                                while(!enterExam.equals("0")){
                                    enterExam = scanner.next().toUpperCase();
                                    Exam addExam = getExamData(enterExam);
                                    studExam.add(addExam);
                                }

                                student.setFirstName(studentName);
                                student.setLastName(studentLastName);
                                student.setYear(studentYear);
                                student.setSubjects(studSub);
                                student.setExams(studExam);

                                student.setId("STU" + database.getStudents().size());

                                ArrayList<Student> temp = database.getStudents();
                                temp.add(student);
                                database.setStudents(temp);

                                break;
                            case 2:

                                //ISPIS STUDENATA DA BI SE MOGAO UNIJET ID STUDENTA KOJEG ZELIMO OBRISATI
                                for (Student s : database.getStudents())
                                    System.out.println(s.getFirstName() + " | " + s.getLastName() + " | " + s.getId());

                                System.out.println("Unesite ID studenta kojeg zelite obrisati: ");
                                String deleteStudent = scanner.next().toUpperCase();

                                //BRISANJE STUDENTA
                                for (Student s : database.getStudents()) {
                                    if (s.getId().equals(deleteStudent)) {
                                        database.getStudents().remove(s);
                                    }
                                }
                                break;

                            case 3:
                                //ISPIS SVIH STUDENATA IZ ARRAYLISTE
                                for (Student s : database.getStudents())
                                    System.out.println(s.getFirstName() + " | " + s.getLastName() + " | " + s.getId());

                                break;

                            case 4:
                                //POZIVANJE METODE ZA ISPIS STUDENATA PO GODINI
                                System.out.println("Unesite godinu za ispis studenata: ");
                                String studYear = scanner.next().toUpperCase();
                                getStudentYear(studYear);
                                break;
                            case 5:
                                //POZIVANJE METODE ZA ISPIS STUDENATA PO PREDMETU
                                System.out.println("Unesite ID predmeta: ");
                                String subjID = scanner.next().toUpperCase();
                                getStudentSubject(subjID);
                                break;
                            default:
                                System.out.println("Neispravan unos! Unesite ponovo: ");
                        }
                    }
                    break;

                case 2:
                    //PROFESOR
                    int choiceTutor = -1;

                    boolean quit1 = false;

                    while (!quit1) {
                        //PROFESOR MENI
                        System.out.println("\nPROFESOR" +
                                "\nIzaberite operaciju: " +
                                "\n0) Izlaz" +
                                "\n1) Dodavanje profesora" +
                                "\n2) Brisanje profesora" +
                                "\n3) Ispis profesora" +
                                "\n4) Ispis profesora po predmetu");
                        choiceTutor = scanner.nextInt();
                        switch (choiceTutor) {
                            case 0:
                                quit1 = true;
                                break;
                            //UNOS PROFESORA
                            case 1:
                                System.out.println("UNOS PROFESORA: ");
                                Tutor tutor = new Tutor();

                                System.out.println("Unesite ime: ");
                                String tutorName = scanner.next();

                                System.out.println("Unesite prezime: ");
                                String tutorLastName = scanner.next();

                                System.out.println("Unesite ID predmeta koje zelite dodijeliti profesoru (nula prekida unos): ");
                                String enterSub = "-1";
                                ArrayList<Subject> profSub = new ArrayList<>();
                                for(Subject s: database.getSubjects())
                                    System.out.println(s.getName() + " | " + s.getId());
                                while(!enterSub.equals("0")){
                                    enterSub = scanner.next().toUpperCase();
                                    Subject addSub = getSubjectData(enterSub);
                                    profSub.add(addSub);
                                }

                                tutor.setFirstName(tutorName);
                                tutor.setLastName(tutorLastName);
                                tutor.setSubjects(profSub);
                                tutor.setId("PROF" + database.getTutors().size());

                                ArrayList<Tutor> temp = database.getTutors();
                                temp.add(tutor);
                                database.setTutors(temp);

                                break;
                            case 2:

                                //ISPIS PROFESORA DA BI SE MOGAO VIDJETI ID PROFESORA KOJEG ZELIMO OBRISATI
                                for (Tutor t : database.getTutors())
                                    System.out.println(t.getFirstName() + " | " + t.getLastName() + " | " + t.getId());

                                System.out.println("Unesite ID profesora kojeg zelite obrisati: ");
                                String deleteTutor = scanner.next().toUpperCase();

                                //BRISANJE PROFESORA
                                for (Tutor t : database.getTutors()) {
                                    if (t.getId().equals(deleteTutor)) {
                                        database.getTutors().remove(t);
                                    }
                                }
                                break;
                            case 3:
                                //ISPIS SVIH PROFESORA IZ ARRAYLISTE
                                for (Tutor t : database.getTutors())
                                    System.out.println(t.getFirstName() + " | " + t.getLastName() + " | " + t.getId());

                                break;
                            case 4:
                                //POZIVANJE METODE ZA ISPIS PROFESORA KOJI PREDAJU NA ODREDJENOM PREDMETU
                                System.out.println("Unesite ID predmeta kod kojeg zelite vidjeti profesora: ");
                                String subjectTutor = scanner.next().toUpperCase();
                                getSubjectTutor(subjectTutor);
                                break;
                            default:
                                System.out.println("Neispravan unos! Unesite ponovo: ");
                        }
                    }
                    break;
                case 3:
                    //PREDMET
                    int choiceSubject = -1;

                    boolean quit2 = false;

                    while (!quit2) {
                        //PREDMET MENI
                        System.out.println("\nPREDMET" +
                                "\nIzaberite operaciju: " +
                                "\n0) Izlaz" +
                                "\n1) Dodavanje predmeta" +
                                "\n2) Brisanje predmeta" +
                                "\n3) Ispis predmeta");
                        choiceSubject = scanner.nextInt();
                        switch (choiceSubject) {
                            case 0:
                                quit2 = true;
                                break;
                            //UNOS PREDMETA
                            case 1:
                                System.out.println("UNOS PREDMETA: ");
                                Subject subject = new Subject();

                                System.out.println("Unesite naziv predmeta: ");
                                String subjectName = scanner.next();

                                System.out.println("Unesite godinu na kojoj se predaje predmet: ");
                                String subjectYear = scanner.next();

                                subject.setName(subjectName);
                                subject.setYear(subjectYear);
                                subject.setId("SUB" + database.getSubjects().size());

                                ArrayList<Subject> temp = database.getSubjects();
                                temp.add(subject);
                                database.setSubjects(temp);

                                break;
                            case 2:

                                //ISPIS PREDMETA DA BI SE MOGAO VIDJETI ID PROFESORA KOJEG ZELIMO OBRISATI
                                for (Subject s : database.getSubjects())
                                    System.out.println(s.getName() + " | " + s.getYear() + " | " + s.getId());

                                System.out.println("Unesite ID predemeta koji zelite obrisati: ");
                                String deleteSubject = scanner.next().toUpperCase();

                                //BRISANJE PREDMETA
                                for (Subject s : database.getSubjects()) {
                                    if (s.getId().equals(deleteSubject)) {
                                        database.getSubjects().remove(s);
                                    }
                                }
                                break;
                            case 3:
                                //ISPIS SVIH PREDMETA IZ ARRAYLISTE
                                for (Subject s : database.getSubjects())
                                    System.out.println(s.getName() + " | " + s.getYear() + " | " + s.getId());

                                break;
                            default:
                                System.out.println("Neispravan unos! Unesite ponovo: ");
                        }
                    }

                    break;
                case 4:
                    //ISPIT
                    int choiceExam = -1;

                    boolean quit3 = false;

                    while (!quit3) {
                        //ISPITI MENI
                        System.out.println("\nISPIT" +
                                "\nIzaberite operaciju: " +
                                "\n0) Izlaz" +
                                "\n1) Dodavanje ispita" +
                                "\n2) Brisanje ispita" +
                                "\n3) Ispis ispita" +
                                "\n4) Ispiti za odredjeni datum");
                        choiceExam = scanner.nextInt();
                        switch (choiceExam) {
                            case 0:
                                quit3 = true;
                                break;
                            //UNOS ISPITA
                            case 1:
                                System.out.println("UNOS ISPITA: ");
                                Exam exam = new Exam();

                                //ISPIS ID PREDMETA KOJI SE MOGU ODABRATI ZA ISPIT
                                System.out.println("Unesite ID predmeta: ");
                                for (Subject s : database.getSubjects())
                                    System.out.println(s.getName() + " | " + s.getYear() + " | " + s.getId());
                                String subjectId = scanner.next().toUpperCase();
                                //POZIVANJE METODE KOJA VRACA VRIJEDNOST SUBJECT
                                Subject subject = getSubjectData(subjectId);

                                System.out.println("Unesti podatke o terminu ispita: ");
                                //POZIVANJE METODE KOJA VRACA VRIJEDNOST DATE
                                Date date = getDateData();

                                System.out.println("Unesite podatke ucionice u kojoj se odrzava ispit: ");
                                //POZIVANJE METODE KOJA VRACA VRIJEDNOST CLASSROOM
                                Classroom classroom = getClassroomData();

                                String examId = ("EXAM" + database.getExams().size());

                                exam.setId(examId);
                                exam.setSubject(subject);
                                exam.setClassroom(classroom);
                                exam.setDate(date);

                                ArrayList<Exam> temp = database.getExams();
                                temp.add(exam);
                                database.setExams(temp);

                                break;
                            case 2:

                                //ISPIS ISPITA DA BI SE MOGAO VIDJETI ID ISPITA KOJEG ZELIMO OBRISATI
                                for (Exam e : database.getExams())
                                    System.out.println(e.getSubject() + " | " + e.getDate() + " | " + e.getClassroom() + " | " + e.getId());

                                System.out.println("Unesite ID ispita koji zelite obrisati: ");
                                String deleteExam = scanner.next().toUpperCase();

                                //BIRSANJE ISPITA
                                for (Exam e : database.getExams()) {
                                    if (e.getId().equals(deleteExam)) {
                                        database.getTutors().remove(e);
                                    }
                                }
                                break;
                            case 3:
                                //ISPIS SVIH ISPITA U ARRAYLISTI
                                for (Exam e : database.getExams())
                                    System.out.println(e.getSubject().getName() + " | " + e.getDate().getDate() + " | " + e.getDate().getTime() + " | " + e.getClassroom().getName() + " | " + e.getId());

                                break;
                            case 4:
                                //POZIVANJE METODE ZA ISPIS ISPITA PO DATUMU
                                System.out.println("Unesite datum za koji zelite provjeriti ispite: ");
                                String examDate = scanner.next().toUpperCase();
                                getExamsByDate(examDate);
                                break;
                            default:
                                System.out.println("Neispravan unos! Unesite ponovo: ");
                        }
                    }
                    break;

                default:
                    System.out.println("Neispravan unos! Odaberite broj ponovo. ");
            }
        }
    }

    //METODA KOJU POZIVAMO U MAINU DA BISMO UNIJELI PODATKE O UCIONICI U KOJOJ SE ODRZAVA ISPIT
    public static Classroom getClassroomData() {

        System.out.println("Unesite ime ucionice: ");
        String name = scanner.next();

        System.out.println("Unesite broj mjesta u ucionici: ");
        int seats = scanner.nextInt();

        String id = ("CR" + database.getClassrooms().size());

        Classroom classroom = new Classroom();
        classroom.setId(id);
        classroom.setName(name);
        classroom.setNumSeats(seats);

        ArrayList<Classroom> temp = database.getClassrooms();
        temp.add(classroom);
        database.setClassrooms(temp);

        return classroom;
    }

    //METODA KOJU POZIVAMO U MAINU DA BISMO UNIJELI PODATKE O DATUMU I VREMENU ODRZAVANJA ISPITA
    public static Date getDateData() {

        System.out.println("Unesite datum odrzavanja ispita: ");
        String date = scanner.next();

        System.out.println("Unesite termin odrzavanja ispita: ");
        String time = scanner.next();

        Date date1 = new Date();

        date1.setDate(date);
        date1.setTime(time);

        return date1;
    }

    //METODA KOJU POZIVAMO U MAINU I DODJELJUJEMO JOJ ID DA BI NASLI PREDMET U LISTI PREDMETA
    //METODA VRACA VRIJEDNOST SUBJECT UKOLIKO PREDMET POSTOJI U LISTI
    public static Subject getSubjectData(String id) {
        Subject subject = null;
        for (int i = 0; i < database.getSubjects().size(); i++) {
            Subject subject1 = database.getSubjects().get(i);
            if (subject1.getId().equals(id))
                subject = subject1;
        }
        return subject;
    }

    public static Exam getExamData(String id){
        Exam exam = null;
        for (int i = 0; i < database.getExams().size(); i++){
            Exam exam1 = database.getExams().get(i);
            if(exam1.getId().equals(id))
                exam = exam1;
        }
        return exam;
    }

    //METODA ZA ISPIS ISPITA PO DATUMU
    public static void getExamsByDate(String examDate) {
        for (Exam e : database.getExams()) {
            if (e.getDate().getDate().equals(examDate))
                System.out.println(e.getSubject().getName() + " | " + e.getDate().getDate() + " | " + e.getDate().getTime() + " | " + e.getClassroom().getName() + " | " + e.getId());
        }
    }

    //METODA ZA ISPIS PROFESORA ZA PROSLJEDJENI PREDMET
    public static void getSubjectTutor(String subjectTutor) {
        for (Subject s : database.getSubjects()) {
            if (s.getId().equals(subjectTutor))
                System.out.println(s.getTutor().getFirstName() + " | " + s.getTutor().getLastName() + " | " + s.getTutor().getId() + " | " + s.getName());
        }
    }

    //METODA ZA ISPIS STUDENATA PO PREDEMETU
    public static void getStudentSubject(String studentSubject) {
        for (Student s : database.getStudents()) {
            for (Subject sub : database.getSubjects()) {
                if (sub.getId().equals(studentSubject))
                    System.out.println(s.getFirstName() + " | " + s.getLastName() + " | " + s.getId() + " | " + sub.getName());
            }
        }

    }

    //METODA ZA ISPIS STUDENATA SA PROSLJEDJENE GODINE
    public static void getStudentYear(String studentYear) {
        for (Student s : database.getStudents()) {
            if (s.getYear().equals(studentYear))
                System.out.println(s.getFirstName() + " | " + s.getLastName() + " | " + s.getId() + " | " + s.getYear());
        }
    }
}
