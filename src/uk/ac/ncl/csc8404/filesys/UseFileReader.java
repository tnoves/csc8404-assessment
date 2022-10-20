package uk.ac.ncl.csc8404.filesys;

import java.util.ArrayList;

public class UseFileReader {
    public static void main(String[] args) {
        ModuleRecords mRecords = new ModuleRecords();
        ArrayList<Module> modules = mRecords.getModules(mRecords.readFile
                ("src/uk/ac/ncl/csc8404/filesys/files/modules.txt"));

        for (Module m : modules) {
            System.out.println(m);
        }

        SupervisorRecords sRecords = new SupervisorRecords();
        ArrayList<String> supervisors = sRecords.readFile("src/uk/ac/ncl/csc8404/filesys/files/supervisors.txt");
        for (String s : supervisors) {
            System.out.println(s);
        }
    }
}
