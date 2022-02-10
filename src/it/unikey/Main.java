package it.unikey;import control.FileLog;

import entities.School;
import entities.Student;
import entities.Tutor;import java.time.LocalDate;

import java.util.Arrays;public class Main { public static void main(String[] args) {

    FileLog.checkUser("alessiog", "1234a"); School.addPerson(new Student("alEssio","GIAnnetti"));

    School.addPerson(new Student("fulvIO", "berretta"));
    School.addPerson(new Student("marco", "berretta"));
    School.addPerson(new Student("alessio", "paolucci"));

    School.addPerson(new Tutor("francesco","di rosa", "1993-12-11"));
    School.addPerson(new Tutor("sara","gaudiosi", "1994-10-20"));
    System.out.println("--------------------");
    Arrays.stream(School.changeListStudentToArr()).forEach(System.out::println);
    System.out.println("--------------------");
    Arrays.stream(School.changeListTutorToArr()).forEach(System.out::println);

    }

}

