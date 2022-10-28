package uk.ac.ncl.csc8404.card;

import uk.ac.ncl.csc8404.stu.Student;

import java.util.Date;

/**
 * SmartCardNumber - A non-abstract extension of
 * SmartCardNumberFactory.
 * Allows for construction of smartcard numbers from
 * a student, date, and serial.
 */

public final class SmartCardNumber extends SmartCardNumberFactory{
    /**
     * Non-abstract constructor method to allow construction
     * of a student card number.
     *
     * @param student to take initials from.
     * @param date to take year from.
     * @param serial arbitrary serial for end of card number.
     */
    public SmartCardNumber(Student student, Date date, int serial) {
        super(student, date, serial);
    }


}
