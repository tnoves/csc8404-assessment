package uk.ac.ncl.csc8404.stu;

import java.util.ArrayList;
import java.util.Date;

import uk.ac.ncl.csc8404.filesys.Module;

/**
 * UG - An extension of AbstractStudent which is configured for an undergraduate student.
 * Implements canBeRegistered method which is missing from AbstractStudent.
 */

public final class UG extends AbstractStudent{
    /* The following variables are shared by all UG students
    and should not be changed.
     */
    public static final String passMark = "40%";
    public static final int requiredCredits = 120;

    /**
     * Public constructor for an undergraduate student given name,
     * date of birth, and chosen modules.
     *
     * @see uk.ac.ncl.csc8404.stu.AbstractStudent()
     * @param chosenModules an arraylist of Modules, or can be null if student is yet to choose.
     */
    public UG(Name name, Date dateOfBirth, ArrayList<Module> chosenModules) {
        super(name, dateOfBirth);
        this.type = "UG";
        if (chosenModules == null) {
            this.chosenModules = null;
        } else {
            this.chosenModules = new ArrayList<>(chosenModules);
        }
    }

    /**
     * Check whether the student has chosen enough credits to register (120).
     *
     * @see uk.ac.ncl.csc8404.stu.Student#canBeRegistered()
     */
    public boolean canBeRegistered() {
        return this.getCredits() == requiredCredits;
    }
}
