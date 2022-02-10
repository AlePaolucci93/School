package entities;

import java.util.*;
import java.util.stream.Collectors;

public class School {
    Student student;

    static public List<Student> listStudent = new ArrayList<>();
    static List<Tutor> listTutor = new ArrayList<>();

    public static void addPerson(Person person){
        String StrSurname = person.getSurname().substring(0,1).toUpperCase() + person.getSurname().substring(1).toLowerCase();
        String StrName = person.getName().substring(0,1).toUpperCase() + person.getName().substring(1).toLowerCase();
        person.setSurname(StrSurname);
        person.setName(StrName);
        if(person instanceof Student){
            listStudent.add((Student) person);
        } else
            listTutor.add((Tutor) person);
    }


    public static Student[] changeListStudentToArr(){
        return listStudent.stream()
                .sorted(Comparator.comparing(Student::getSurname).thenComparing(Person::getName))
                .collect(Collectors.toList())
                .toArray(new Student[0]);
    }


    public static Tutor[] changeListTutorToArr(){
        return listTutor.stream()
                .sorted(Comparator.comparing(Tutor::getSurname).thenComparing(Tutor::getName))
                .collect(Collectors.toList())
                .toArray(new Tutor[0]);
    }


}
