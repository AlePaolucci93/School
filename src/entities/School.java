package entities;

import exception.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class School {

    Student student;

    public static Set<Student> setStudent = new HashSet<>();
    public static Set<Tutor> setTutor = new HashSet<>();

    static public Map<Student, Tutor> mapStudentTutor = new HashMap<>();
    static public Map<Tutor, Set<Student>> mapTutorStudent = new HashMap<>();

    public static void addPerson(Person person){
        String StrSurname = person.getSurname().substring(0,1).toUpperCase() + person.getSurname().substring(1).toLowerCase();
        String StrName = person.getName().substring(0,1).toUpperCase() + person.getName().substring(1).toLowerCase();
        person.setSurname(StrSurname);
        person.setName(StrName);
        if(person instanceof Student){
            setStudent.add((Student) person);
        } else
            setTutor.add((Tutor) person);
    }


    public static Student[] changeSetStudentToArr(){
        return setStudent.stream()
                .sorted(Comparator.comparing(Student::getSurname).thenComparing(Person::getName))
                .collect(Collectors.toList())
                .toArray(new Student[0]);
    }


    public static Tutor[] changeSetTutorToArr(){
        return setTutor.stream()
                .sorted(Comparator.comparing(Tutor::getSurname).thenComparing(Tutor::getName))
                .collect(Collectors.toList())
                .toArray(new Tutor[0]);
    }






}
