package uk.ac.ncl.csc8404.filesys;

import java.util.ArrayList;

/**
 * ModuleRecords - An extension of FileReader for
 * reading modules from a file and constructing Module
 * objects to be returned in an arraylist.
 * Also has functionality to list the modules from an
 * arraylist.
 */

public final class ModuleRecords extends FileReader{
    private final ArrayList<Module> modules = new ArrayList<>();

    /**
     * Converts the arraylist of Strings into an arraylist of
     * modules.
     *
     * @param moduleString arraylist of Strings with the raw module
     *                     data from the maintained modules record.
     * @return arraylist of Modules.
     */
    public ArrayList<Module> getModules(ArrayList<String> moduleString) {
        for (String s : moduleString) {
            String[] string = s.split(", ");
            Module newModule = new Module(string[0], string[1], Integer.parseInt(string[2]));
            this.modules.add(newModule);
        }
        return modules;
    }

    /**
     * Display each module in a provided arraylist.
     *
     * @param modules an arraylist of Modules.
     */
    public void listModules(ArrayList<Module> modules) {
        for (Module m : modules) {
            System.out.println(m);
        }
    }
}
