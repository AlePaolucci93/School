package fileGestion;

import entities.School;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;



public class FileGestion {

    static String pathStudent = "C:\\Users\\paolu\\IdeaProjects\\Scuola\\src\\log\\listStudent.txt";
    static String pathTutor = "C:\\Users\\paolu\\IdeaProjects\\Scuola\\src\\log\\listTutor.txt";

    public static void writeListStudent(){
        School.setStudent.forEach(s -> {
            try {
                Files.write(Paths.get(pathStudent),(s.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }//end method

    public static void writeListTutor() {
        School.setTutor.forEach(s -> {
            try {
                Files.write(Paths.get(pathTutor), (s.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }); //end method



    } //end class



}//endClass