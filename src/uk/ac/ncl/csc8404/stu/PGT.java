package uk.ac.ncl.csc8404.stu;

import java.util.ArrayList;
import java.util.Date;

import uk.ac.ncl.csc8404.filesys.Module;

/**
 * PGT - An extension of AbstractStudent which is configured for a postgraduate taught student.
 * Implements canBeRegistered method which is missing from AbstractStudent.
 */

public final class PGT extends AbstractStudent{
    /* The following variables are shared by all PGT students
    and should not be changed.
     */
    public static final String passMark = "50%";
    public static final int requiredCredits = 180;

    /**
     * Public constructor for a postgraduate taught student given name,
     * date of birth, and chosen modules.
     *
     * @see uk.ac.ncl.csc8404.stu.AbstractStudent()
     * @param chosenModules an arraylist of Modules, or can be null if student is yet to choose.
     */
    public PGT(Name name, Date dateOfBirth, ArrayList<Module> chosenModules) {
        super(name, dateOfBirth);
        this.type = "PGT";
        if (chosenModules == null) {
            this.chosenModules = null;
        } else {
            this.chosenModules = new ArrayList<>(chosenModules);
        }
    }

    /**
     * Check whether the student has chosen enough credits to register (180).
     *
     * @see uk.ac.ncl.csc8404.stu.Student#canBeRegistered()
     */
    public boolean canBeRegistered() {
        return this.getCredits() == requiredCredits;
    }
}