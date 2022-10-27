package uk.ac.ncl.csc8404.stu;

import java.util.Date;

/**
 * Student - interface to student information.
 */

public interface Student {
    /**
     * Assigns the student a StudentID.
     *
     * @param id an instance of a StudentID.
     * @throws NullPointerException if <code>id == null</code>.
     */
    public default void setID(StudentID id) {};

    /**
     * Returns the StudentID from the student.
     * All registered students have an id which uniquely identifies them.
     * @return the StudentID held by the student.
     */
    public StudentID getID();

    /**
     * Returns the type of student.
     * Students can be one of 3 types: UG, PGT, PGR
     *
     * @return the type of student
     */
    public String getType();

    /**
     * Lists the modules the student has chosen.
     * Students will not choose modules if they are PGR.
     */
    public void listModules();

    /**
     * Check whether a student can be registered.
     * These conditions are specific to each type of student.
     *
     * @return if a student meets the criteria to be registered.
     */
    public boolean canBeRegistered();

    /**
     * Gets a copy of the full name of the student.
     *
     * @return the full name of the student.
     */
    public Name getName();

    /**
     * Gets the date of birth of the student.
     *
     * @return the date of birth of the student.
     */
    public Date getDateOfBirth();

}
