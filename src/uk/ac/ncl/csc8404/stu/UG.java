package uk.ac.ncl.csc8404.stu;

import java.util.ArrayList;
import java.util.Date;

import uk.ac.ncl.csc8404.filesys.Module;

public class UG extends AbstractStudent{
    private static final String passMark = "40%";
    private static final int requiredCredits = 120;
    private static final String type = "UG";

    public UG(Name name, Date dateOfBirth, ArrayList<Module> chosenModules) {
        super(name, dateOfBirth);
        this.chosenModules = chosenModules;
    }

    public boolean canBeRegistered() {
        return this.getCredits() == requiredCredits;
    }
}
