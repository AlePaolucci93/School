package it.unikey;

import Menù.UserInterface;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import control.FileLog;
import entities.School;
import entities.Student;
import entities.Tutor;
import exception.TutorAlreadyExsistsException;
import fileGestion.FileGestion;
import java.time.LocalDate;
import java.util.Arrays;
import static entities.School.mapStudentTutor;
import static entities.School.mapTutorStudent;

public class Main {
    public static void main(String[] args) {

        FileLog.checkUser("alessiog", "1234a");

        /*Tutor francesco = new Tutor("francesco", "di rosa", "1993-12-11");
        Tutor sara = new Tutor("sara", "gaudiosi", "1994-10-20");
        Tutor mario = new Tutor("mario", "rossi", "1990-05-14");
        Student luca = new Student("luca", "verdi");
        Student gianni = new Student("Gianni", "Morandi");
        Student alessiog = new Student("alEssio", "GIAnnetti");
        Student fulvio = new Student("fulvIO", "berretta");
        Student marco = new Student("marco", "berretta");
        Student alessiop = new Student("alessio", "paolucci");
        Student gianniOmonimo = new Student("Gianni", "Morandi");

        School.addPerson(alessiog);
        School.addPerson(fulvio);
        School.addPerson(marco);
        School.addPerson(alessiop);
        School.addPerson(gianniOmonimo);
        School.addPerson(gianni);
        School.addPerson(luca);
        School.addPerson(francesco);
        School.addPerson(mario);
        School.addPerson(sara);


        System.out.println("--------------------");
        Arrays.stream(School.changeSetStudentToArr()).forEach(System.out::println);
        System.out.println("--------------------");
        Arrays.stream(School.changeSetTutorToArr()).forEach(System.out::println);

        FileGestion.writeListStudent();
        FileGestion.writeListTutor();

        sara.assignStudentToTutor(fulvio);
        mario.assignStudentToTutor(luca);
        francesco.assignStudentToTutor(luca);
        mario.assignStudentToTutor(gianni);
        mario.assignStudentToTutor(gianniOmonimo);
        Tutor.printStudentForTutor();*/

        UserInterface us = new UserInterface();
        UserInterface.launchMenu();


    }

}

