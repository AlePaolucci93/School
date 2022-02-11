package entities;

import exception.NotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static entities.School.listTutor;
import static entities.School.mapTutorStudent;

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
        for (Tutor tutor : mapTutorStudent.keySet()) {
            if(tutor.getIdTutor() == this.idTutor)
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

    public void insertTutor(Student student) {
        if (!this.tutorIsPresentInHashMap()) {
            mapTutorStudent.put(this, new ArrayList<>(Arrays.asList(student)));
        } else {
            mapTutorStudent.get(this).add(student);
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
