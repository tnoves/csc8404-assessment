package uk.ac.ncl.csc8404.filesys;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader implements File{
    public ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> readFile(String filepath) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new java.io.FileReader(filepath));
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
            reader.close();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
