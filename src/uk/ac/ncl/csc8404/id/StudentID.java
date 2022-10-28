package uk.ac.ncl.csc8404.id;

/**
 * StudentID - Interface for the student ID.
 */

public interface StudentID {
    /**
     * Getter method to get the first letter of the
     * ID.
     *
     * @return the first character of an id.
     */
    String getLetter();

    /**
     * Getter method to get the digits of the id.
     *
     * @return the 4 digits of an id.
     */
    String getDigits();

}
