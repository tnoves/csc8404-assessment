package uk.ac.ncl.csc8404.stu;

import java.util.HashMap;
import java.util.Map;

public abstract class StudentIDFactory implements StudentID {
    private static final Map<String, StudentID> studentIDs = new HashMap<String, StudentID>();
    private final String idString;
    private final String letter;
    private final String digits;

    @Override
    public String toString() {
        return letter + digits;
    }

    @Override
    public String getLetter() {
        return this.letter;
    }

    @Override
    public String getDigits() {
        return this.digits;
    }

    StudentIDFactory(String idString) throws IllegalArgumentException, NumberFormatException{
        if (idString.length() == 0) {
            throw new IllegalArgumentException("id cannot be blank");
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

    public static StudentID getInstance(String idString) {
        StudentID id = studentIDs.get(idString);

        if (id != null) {
            return id;
        }

        id = new ID(idString);
        studentIDs.put(idString, id);

        return id;
    }
}
