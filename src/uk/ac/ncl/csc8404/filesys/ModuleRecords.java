package uk.ac.ncl.csc8404.filesys;

import java.util.ArrayList;

public final class ModuleRecords extends FileReader{
    private final ArrayList<Module> modules = new ArrayList<>();

    public ArrayList<Module> getModules(ArrayList<String> moduleString) {
        for (String s : moduleString) {
            String[] string = s.split(", ");
            Module newModule = new Module(string[0], string[1], Integer.parseInt(string[2]));
            this.modules.add(newModule);
        }
        return modules;
    }

    public void listModules(ArrayList<Module> modules) {
        for (Module m : modules) {
            System.out.println(m);
        }
    }
}
