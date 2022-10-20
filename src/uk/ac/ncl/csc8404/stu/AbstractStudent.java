package uk.ac.ncl.csc8404.stu;

import java.util.ArrayList;
import java.util.Date;

import uk.ac.ncl.csc8404.filesys.Module;

public abstract class AbstractStudent implements Student{
    private Name name;
    private final Date dateOfBirth;
    private String type;
    private ID id;
    ArrayList<Module> chosenModules;

    public AbstractStudent(Name name, Date dateOfBirth) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }

        if (dateOfBirth == null) {
            throw new IllegalArgumentException("date of birth must not be null");
        }

        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public ID getID() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void listModules() {
        if (chosenModules == null) {
            System.out.println("No modules chosen");
        } else {
            for (Module m : chosenModules) {
                System.out.println(m);
            }
        }
    }

    public int getCredits() {
        int credits = 0;
        for (Module m : chosenModules) {
            credits += m.getCredits();
        }
        return credits;
    }

}
