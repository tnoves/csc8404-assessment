package uk.ac.ncl.csc8404.filesys;

import java.util.ArrayList;

public interface File {
    ArrayList<String> readFile(String filepath);
}
