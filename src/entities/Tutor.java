package entities;

import exception.NotFoundException;
import exception.TutorAlreadyExsistsException;

import java.time.LocalDate;
import java.util.*;

import static entities.School.*;

public class Tutor extends Person {

    private LocalDate birthDate;
    private int idTutor;
    private static int counter;


    public Tutor(String name, String surname, String birthDate) {

        super(name, surname);
        this.birthDate = LocalDate.parse(birthDate);
        counter++;
        this.idTutor = counter;

    }

    //metodo per controllare se il tutor è presente nella mappa importata in questa classe e presente in School
    public boolean tutorIsPresentInHashMap() {
        for (Tutor tutor : mapTutorStudent.keySet()) { //ciclo per ogni tutor di tipo Tutor presente nel set delle chiavi di quella det mappa (a dx mi dice dove vado a prenderli)
            if (tutor.getIdTutor() == this.idTutor)
                return true;

        }
        return false;
    }

    //Optional è contenitore di ogg che serve a non far crushare il programma se non trova l'ogg (in questo caso Tutor), inoltre se non è presente posso lanciare un eccezione
    /*public Optional<Tutor> findTutorById (int idTutor){
        return  listTutor.stream()
                .filter(x -> x.getIdTutor() == idTutor)
                .findFirst();
    }*/

    public void assignStudentToTutor(Student student) {
        try {
            if(!student.hasAssignedTutor()) {
                if (!this.tutorIsPresentInHashMap()) {
                    Set<Student> setStudent = new HashSet<>();
                    setStudent.add(student);
                    mapTutorStudent.put(this, setStudent);
                } else {
                    mapTutorStudent.get(this).add(student);
                }
            }else {
                throw new TutorAlreadyExsistsException(student, this);
            }

        }  catch (TutorAlreadyExsistsException e) {
            e.printStackTrace();
        }
    }

    //per ogni tutor presente nel mapTutorStudent stampa la lista di studenti associati
    public static void printStudentForTutor() {
        for (Tutor elem : mapTutorStudent.keySet()) {
            System.out.println("Lista di studenti del tutor " + elem.getName() + ": \n" + mapTutorStudent.get(elem));
            }
        }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " " + getBirthDate();
    }

}//end class
