package uk.ac.ncl.csc8404.stu;

import java.util.Date;

/**
 * PGR - An extension of AbstractStudent which is configured for a postgraduate research student.
 * Implements canBeRegistered which is missing from AbstractStudent.
 */

public final class PGR extends AbstractStudent{
    public String supervisor;

    /**
     * Public constructor for a postgraduate research student given name,
     * date of birth, and supervisor.
     *
     * @see uk.ac.ncl.csc8404.stu.AbstractStudent()
     * @param supervisor the name of the student's supervisor as a string.
     * @throws NullPointerException if supervisor is null.
     * @throws IllegalArgumentException if supervisor is empty.
     */
    public PGR(Name name, Date dateOfBirth, String supervisor) {
        super(name, dateOfBirth);
        if (supervisor == null) {
            throw new NullPointerException("supervisor must not be null");
        }
        this.supervisor = supervisor;
        this.type = "PGR";
    }

    /**
     * Check whether the student has a supervisor and therefore
     * can be registered.
     *
     * @see uk.ac.ncl.csc8404.stu.Student#canBeRegistered()
     */
    public boolean canBeRegistered() {
        return supervisor.length() != 0;
    }

    /**
     * Get the name of the student's supervisor.
     *
     * @return the name of the supervisor.
     */
    public String getSupervisor() {
        return supervisor;
    }
}
