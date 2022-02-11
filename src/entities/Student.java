package entities;

import java.util.Objects;

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
    /*public boolean hasAssignedTutor(){
        boolean isPresentInStudentsSet = setStudent.stream().map(Student::getSerialNumber).anyMatch(elem -> elem.equals(this.serialNumber));
        boolean isPresentInTutorsSet = mapTutorStudent.keySet().stream().anyMatch(elem -> mapTutorStudent.get(elem).contains(this));
        return (isPresentInStudentsSet && !isPresentInTutorsSet) ? false : true;
    }*/

    public  boolean hasAssignedTutor(){

        boolean isPresentInStudentsSet = false;
        boolean isPresentInTutorsSet = false;
        for (Student elem : setStudent){
            if(elem.getSerialNumber() == this.serialNumber)
                isPresentInStudentsSet = true;
        }

        for (Tutor elem : mapTutorStudent.keySet()) {
            if((mapTutorStudent.get(elem)).contains(this))
                isPresentInTutorsSet = true;
        }
        if(isPresentInStudentsSet && !isPresentInTutorsSet) return false;
        return true;
    }

    //per ogni studente
    public static void printTutorForStudent() {
        for (Student elem : mapStudentTutor.keySet()) {
            System.out.println("Lo studente " + elem.getName() + "ha il seguente tutor: \n" + mapStudentTutor.get(elem));
        }
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " " + getSerialNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return serialNumber == student.serialNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }
}
