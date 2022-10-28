package uk.ac.ncl.csc8404.card;

import uk.ac.ncl.csc8404.stu.Name;
import uk.ac.ncl.csc8404.id.StudentID;

import java.util.Date;

/**
 * SmartCardInterface - interface for smartcards.
 */

public interface SmartCardInterface {
    /**
     * Gets the name of the student linked to the
     * smart card
     *
     * @return name of the student.
     */
    public Name getName();

    /**
     * Gets the date of birth of the student linked
     * to the smart card.
     *
     * @return date of birth of the student
     */
    public Date getDateOfBirth();

    /**
     * Gets the student id linked to the smart card.
     *
     * @return student id.
     */
    public StudentID getStudentID();

    /**
     * Gets the date of issue of the smart card.
     * This is provided when a smartcard is created.
     * @return date of issue.
     */
    public Date getDateOfIssue();

    /**
     * Sets the expiry date on the smart card.
     * This is performed upon construction of a
     * smartcard.
     */
    private void setExpiryDate() {
    }

    /**
     * Gets the expiry date of the smart card.
     *
     * @return the expiry date of the smart card.
     */
    public Date getExpiryDate();
}
