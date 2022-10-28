package uk.ac.ncl.csc8404.filesys;

import java.util.ArrayList;

/**
 * File - Interface for basic file handling.
 */

public interface File {
    /**
     * Fetches an arraylist of strings from a specified filepath.
     * @param filepath path to a file to read data from.
     * @return an arraylist of each line in the file seperated or null
     * on an IOException.
     */
    ArrayList<String> readFile(String filepath);
}
