package uk.ac.ncl.csc8404.filesys;

import java.util.ArrayList;

public final class SupervisorRecords extends FileReader {
    public ArrayList<String> readFile(String filepath) {
        super.readFile(filepath);
        return list;
    }
}
