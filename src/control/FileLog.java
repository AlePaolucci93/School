package control;

import exception.PasswordNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class FileLog {

    static String path = "C:\\Users\\paolu\\IdeaProjects\\Scuola\\src\\log\\users.txt";

    public static void checkUser(String user, String password) {

        try {
            Map<String, String> mapUser = new HashMap<>();

            String users;
            String passwords;

            FileReader fr = new FileReader(path);
            BufferedReader readerFile = new BufferedReader(fr);

            String read;

            while ((read = readerFile.readLine()) != null) {
                mapUser.put(read.substring(0, read.indexOf(":")), read.substring(read.indexOf(":") + 1));
            }
            for (String a : mapUser.keySet()) {
                if (a.equals(user)) {
                    if (mapUser.get(a).equals(password))
                        System.out.println("L'user è esistente");
                    else
                        throw new PasswordNotFoundException("Non sei registrato!");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PasswordNotFoundException e) {
            e.printStackTrace();
        }

    }//end method

}//end calss