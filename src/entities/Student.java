package entities;

import static entities.School.*;

public class Student extends Person {

    private int serialNumber;
    private static int counter;

    public Student(String name, String surname) {

        super(name, surname);
        counter ++;
        this.serialNumber = counter;
    }

    //metodo per capire se lo studente ha un tutor
    //Lo scopo di questo metodo è evitare che ad un singolo studente siano assegnati più tutor
    public boolean hasAssignedTutor(){
        boolean isPresentInStudentsSet = setStudent.stream().anyMatch(elem -> elem.equals(this));
        boolean isPresentInTutorsSet = mapTutorStudent.keySet().stream().anyMatch(elem -> mapTutorStudent.get(elem).equals(this));
        return (isPresentInStudentsSet && !isPresentInTutorsSet) ? false : true;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " " + getSerialNumber();
    }
}
