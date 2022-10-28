package uk.ac.ncl.csc8404.filesys;

import java.util.ArrayList;

/**
 *  SupervisorRecords - An extension of FileReader
 *  to return an arraylist containing the names of
 *  supervisors as Strings.
 */

public final class SupervisorRecords extends FileReader {
    /**
     * @see uk.ac.ncl.csc8404.filesys.FileReader#readFile(String)
     */
    public ArrayList<String> readFile(String filepath) {
        super.readFile(filepath);
        return list;
    }
}
