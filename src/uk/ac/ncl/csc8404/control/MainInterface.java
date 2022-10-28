package uk.ac.ncl.csc8404.control;

import uk.ac.ncl.csc8404.stu.AbstractStudent;
import uk.ac.ncl.csc8404.stu.Student;
import uk.ac.ncl.csc8404.id.StudentID;

/**
 * MainInterface - Interface to be used by the university for managing
 * student data.
 */

public interface MainInterface {
    /**
     * Gets the number of students of a specified type that are
     * currently enrolled.
     *
     * @param typeOfStudent "UG", "PGT", or "PGR".
     * @return the number of students enrolled of that type.
     */
    int noOfStudents(String typeOfStudent);

    /**
     * Registers a student onto the system and allocates a
     * provided student ID to the student.
     * The system is designed to take an ID as a string input,
     * and if the ID does not already exist then it will assign it.
     *
     * @param student an implementation of a Student object.
     * @param idString a proposed id for the student.
     * @throws IllegalArgumentException if <code>idString</code> is incorrectly
     * formatted or if the ID already exists.
     */
    void registerStudent(Student student, String idString);

    /**
     * Changes a student record.
     * @param id the id of the student whose record is being changed.
     * @param studentData an implementation of a Student object - this
     *                    should be a UG, PGT, or PGR object.
     */
    void amendStudentData(StudentID id, AbstractStudent studentData);

    /**
     * Removes the student record associated with the student id.
     * @param id the id of the student to be removed.
     */
    void terminateStudent(StudentID id);

}
