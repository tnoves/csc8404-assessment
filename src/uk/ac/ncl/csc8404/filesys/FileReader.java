package uk.ac.ncl.csc8404.filesys;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * FileReader - Implementation of File.
 */

public class FileReader implements File{
    public ArrayList<String> list = new ArrayList<>();

    /**
     * @see uk.ac.ncl.csc8404.filesys.File
     * Buffered reader which reads and adds each line of a
     * provided file into an arraylist to be returned.
     */
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
