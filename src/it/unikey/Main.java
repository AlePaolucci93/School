package it.unikey;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import control.FileLog;

import entities.School;
import entities.Student;
import entities.Tutor;
import fileGestion.FileGestion;

import java.time.LocalDate;

import java.util.Arrays;

import static entities.School.mapStudentTutor;
import static entities.School.mapTutorStudent;

public class Main { public static void main(String[] args) {

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

    FileGestion.writeListStudent();
    FileGestion.writeListTutor();

    Tutor mario = new Tutor("Mario", "Rossi", "1990-05-14");
    Student luca = new Student("Luca", "Verdi");
    mario.insertTutor(luca);

    //per ogni tutor presente nel mapTutorStudent stampa la lista di studenti associati
    for (Tutor elem: mapTutorStudent.keySet()) {
        System.out.println("Lista di studenti del tutor " + elem.getName() + ": \n" + mapTutorStudent.get(elem));
    }


    }

}

