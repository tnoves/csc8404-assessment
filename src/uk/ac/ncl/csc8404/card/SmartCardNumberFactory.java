package uk.ac.ncl.csc8404.card;

import uk.ac.ncl.csc8404.stu.Student;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * SmartCardNumberFactory - factory for smartcard numbers.
 * Designed to allow for generation of new smartcard numbers
 * while ensuring there are no duplicated numbers (smartcard
 * numbers are unique).
 */

public abstract class SmartCardNumberFactory{
    private final String initials;
    private final int year;
    private final int serial;
    /*
    Static as the map should be persistent across program.
    Maps a string representation of a smartcard number to
    the smartcard number.
     */
    private static final Map<String, SmartCardNumber> smartCardNumbers = new HashMap<>();

    /**
     * Constructs a SmartCardNumber from provided parameters.
     *
     * @param student student to generate the number for.
     * @param date date of issue of the smartcard.
     * @param serial arbitrary serial for uniqueness.
     * @throws NullPointerException if any of the student or date
     * parameters are null.
     */
    SmartCardNumberFactory(Student student, Date date, int serial) throws NullPointerException{

        if (student == null || date == null) {
            throw new NullPointerException("parameters cannot be null");
        }

        this.initials = String.valueOf(student.getName().getFirstName().charAt(0)) +
                String.valueOf(student.getName().getLastName().charAt(0));

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        this.year = cal.get(Calendar.YEAR);

        this.serial = serial;
    }

    /**
     * Returns a studentNumber from the mapping if the one
     * provided does not already exist.
     * @param number a proposed smartcard number to add to the mapping.
     * @return the smartcard number from the mapping if the number was
     * unique.
     * @throws IllegalArgumentException if the smartcard number already exists.
     */
    public static SmartCardNumber getInstance(SmartCardNumber number) throws IllegalArgumentException{
        final String n = number.toString();
        if (!smartCardNumbers.containsKey(n)) {
            smartCardNumbers.put(n, number);
            return smartCardNumbers.get(n);
        } else {
            throw new IllegalArgumentException("smartcard number already exists - not unique");
        }
    }

    /**
     * Overrides method to get a user readable output.
     *
     * @return the smartcard number in format
     * INITIALS-YEAR-SERIAL
     */
    @Override
    public String toString() {
        return initials + "-" + year + "-" + serial;
    }

    /**
     * Static method to remove a smartcard number from the mapping.
     * Essentially freeing that number to be reused.
     *
     * @param card the smartcard to be removed
     */
    public static void removeNumber(SmartCard card){
        smartCardNumbers.remove(card.getSmartCardNumber());
    }
}
