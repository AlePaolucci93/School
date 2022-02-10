package entities;

public class Student extends Person {

    private int serialNumber;
    private static int counter;

    public Student(String name, String surname) {

        super(name, surname);
        counter ++;
        this.serialNumber = counter;

    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " " + getSerialNumber();
    }
}
