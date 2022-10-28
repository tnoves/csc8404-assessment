package uk.ac.ncl.csc8404.id;

/**
 * ID - A non-abstract extension of StudentID.
 * Allows for construction of ID's from strings.
 */

public class ID extends StudentIDFactory{
    /**
     * Non-abstract constructor method to allow
     * construction of a StudentID.
     * @param idString string in format "x0000"
     *                 where x is any letter and
     *                 0000 is any 4-digit number.
     * @see StudentIDFactory#StudentIDFactory
     */
    ID(String idString) {
        super(idString);
    }
}
