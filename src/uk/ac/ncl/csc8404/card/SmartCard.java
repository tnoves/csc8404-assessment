package uk.ac.ncl.csc8404.card;

import uk.ac.ncl.csc8404.stu.Name;
import uk.ac.ncl.csc8404.stu.Student;
import uk.ac.ncl.csc8404.id.StudentID;

import java.util.Calendar;
import java.util.Date;

/**
 * SmartCard - implementation of SmartCardInterface.
 * Adds all required methods.
 */

public class SmartCard implements SmartCardInterface {
    // Once assigned, the following 3 objects should not change.
    private final Student student;
    private final SmartCardNumber number;
    private final Date dateOfIssue;
    private Date dateOfExpiry;

    /**
     * Constructor method for a smartcard object.
     * Requires the user choose a serial number.
     * Throws an exception if the smart card cannot be
     * generated.
     *
     * @param student Student to generate card for.
     * @param dateOfIssue Starting date for the card.
     * @param serial integer chosen by user.
     * @throws NullPointerException if either the student or
     * dateOfIssue are null.
     * @throws IllegalArgumentException if the smartcard number
     * that would be generated already exists.
     */
    public SmartCard(Student student, Date dateOfIssue, int serial)
            throws NullPointerException, IllegalArgumentException {
        if (student == null || dateOfIssue == null) {
            throw new NullPointerException("parameters cannot be null");
        }

        SmartCardNumber proposedNumber = new SmartCardNumber(student, dateOfIssue, serial);
        this.number = SmartCardNumberFactory.getInstance(proposedNumber);

        this.student = student;
        this.dateOfIssue = dateOfIssue;
        this.setExpiryDate();
    }

    /**
     * @see uk.ac.ncl.csc8404.card.SmartCardInterface#getName()
     */
    public Name getName() {
        return student.getName();
    }

    /**
     * @see uk.ac.ncl.csc8404.card.SmartCardInterface#getDateOfBirth()
     */
    public Date getDateOfBirth() {
        return student.getDateOfBirth();
    }

    /**
     * @see uk.ac.ncl.csc8404.card.SmartCardInterface#getStudentID()
     */
    public StudentID getStudentID() {
        return student.getID();
    }

    /**
     * @see uk.ac.ncl.csc8404.card.SmartCardInterface#getDateOfIssue()
     */
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    /**
     * Assigns the expiry date dependent on the student's
     * type.
     * UG - issue date + 4
     * PGT - issue date + 2
     * PGR - issue date + 5
     *
     * @see uk.ac.ncl.csc8404.card.SmartCardInterface#setExpiryDate
     */
    private void setExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateOfIssue);

        if (this.student.getType() == "UG") {
            cal.add(Calendar.YEAR, 4);
        } else if (this.student.getType() == "PGT") {
            cal.add(Calendar.YEAR, 2);
        } else if (this.student.getType() == "PGR") {
            cal.add(Calendar.YEAR, 5);
        }

        this.dateOfExpiry = cal.getTime();
    }

    /**
     * @see uk.ac.ncl.csc8404.card.SmartCardInterface#getExpiryDate()
     */
    public Date getExpiryDate() {
        return this.dateOfExpiry;
    }

    /**
     * Functionality to get a card number as a string.
     * Added mainly for testing.
     */
    public String getSmartCardNumber() {
        return this.number.toString();
    }
}
