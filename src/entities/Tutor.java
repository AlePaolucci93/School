package entities;

import java.time.LocalDate;

public class Tutor extends Person {

    private LocalDate birthDate;


    public Tutor(String name, String surname, String birthDate) {

        super(name, surname);
        this.birthDate = LocalDate.parse(birthDate);

    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " " + getBirthDate();
    }
}//end class
