package uk.ac.ncl.csc8404.id;

import java.util.HashMap;
import java.util.Map;

/**
 * StudentIDFactory - factory for student ids that also provides implementation
 * of StudentID. This is designed to allow for generation of new ids while
 * ensuring there are no duplicated ids (ids are unique).
 */

public abstract class StudentIDFactory implements StudentID {
    /*
    Static as the map should be persistent across program.
    Maps a string representation of an id to the id.
     */
    private static final Map<String, StudentID> studentIDs = new HashMap<String, StudentID>();
    private final String idString;
    private final String letter;
    private final String digits;

    /**
     * @see java.lang.Object#toString()
     * Overrides method to provide more usable information.
     *
     * @return the id as a string.
     */
    @Override
    public String toString() {
        return letter + digits;
    }

    /**
     * @see StudentID#getLetter()
     */
    public String getLetter() {
        return this.letter;
    }

    /**
     * @see StudentID#getDigits()
     */
    public String getDigits() {
        return this.digits;
    }

    /**
     * Constructs an id from a provided string.
     *
     * @param idString string representation of an id.
     * @throws IllegalArgumentException if the string is empty, or in the
     * incorrect format, see {@link ID#ID}
     * @throws NullPointerException if the string is null.
     */
    StudentIDFactory(String idString) throws IllegalArgumentException, NullPointerException{
        if (idString == null) {
            throw new NullPointerException("idString cannot be null");
        }
        if (idString.length() == 0) {
            throw new IllegalArgumentException("id cannot be empty");
        }
        if (!Character.isLetter(idString.charAt(0))) {
            throw new IllegalArgumentException("id must begin with character");
        }
        if (!idString.substring(1).matches("[0-9]+")
                || idString.substring(1).length() != 4) {
            throw new IllegalArgumentException("ending of id must be 4 digits");
        }

        this.idString = idString;
        this.letter = String.valueOf(idString.charAt(0)).toLowerCase();
        this.digits = idString.substring(1);
    }

    /**
     * Returns an id with the specified details if it doesn't already exist.
     * To gain access to a StudentID after it's initial creation, it should
     * be accessed from a Student.
     *
     * @param idString string representation of an id.
     * @return student id object with the id provided.
     * @throws NullPointerException if the provided string is null.
     * @throws IllegalArgumentException if the string is empty, or in the
     * incorrect format, see {@link ID#ID}, or if
     * the id already exists.
     */
    public static StudentID makeInstance(String idString) {
        StudentID id = studentIDs.get(idString);

        if (id != null) {
            throw new IllegalArgumentException("this id already exists");
        }

        id = new ID(idString);
        studentIDs.put(idString, id);

        return id;
    }
}
