package uk.ac.ncl.csc8404.stu;

import java.util.ArrayList;
import java.util.Date;

import uk.ac.ncl.csc8404.filesys.Module;

public class PGT extends AbstractStudent{
    private static final String passMark = "50%";
    private static final int requiredCredits = 180;
    private static final String type = "PGT";

    public PGT(Name name, Date dateOfBirth, ArrayList<Module> chosenModules) {
        super(name, dateOfBirth);
        this.chosenModules = chosenModules;
    }

    public boolean canBeRegistered() {
        return this.getCredits() == requiredCredits;
    }
}