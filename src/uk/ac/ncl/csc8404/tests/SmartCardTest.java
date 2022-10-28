package uk.ac.ncl.csc8404.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.ac.ncl.csc8404.card.SmartCard;
import uk.ac.ncl.csc8404.stu.*;

import java.util.Calendar;
import java.util.Date;

/**
 * SmartCardTest - tests for creating smart cards.
 * Testing ignores some getter methods which use methods
 * tested in  {@link uk.ac.ncl.csc8404.tests.StudentTest}.
 */
public class SmartCardTest {

    /**
     * Test method for {@link SmartCard}
     * covering both getDateOfIssue and getDateOfExpiry, the
     * latter being checked for all three student types.
     */
    @Test
    public final void testGetDates() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG student = new UG(name, dob, null);
        final PGT student2 = new PGT(name, dob, null);
        final PGR student3 = new PGR(name, dob, "test");

        final Date doi = new Date();
        final SmartCard sc = new SmartCard(student, doi, 0);
        final SmartCard sc2 = new SmartCard(student2, doi, 1);
        final SmartCard sc3 = new SmartCard(student3, doi, 2);

        assertEquals(doi, sc.getDateOfIssue());

        Calendar cal = Calendar.getInstance();
        cal.setTime(sc.getDateOfIssue());
        cal.add(Calendar.YEAR, 4);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(sc2.getDateOfIssue());
        cal2.add(Calendar.YEAR, 2);

        Calendar cal3 = Calendar.getInstance();
        cal3.setTime(sc3.getDateOfIssue());
        cal3.add(Calendar.YEAR, 5);

        assertEquals(cal.getTime(), sc.getExpiryDate());
        assertEquals(cal2.getTime(), sc2.getExpiryDate());
        assertEquals(cal3.getTime(), sc3.getExpiryDate());
    }

    /**
     * Test method for {@link SmartCard#SmartCard}
     * checking for behaviour when the student is null.
     */
    @Test (expected = NullPointerException.class)
    public final void testConstructorStudent() {
        final Date date = new Date();
        final Name name = new Name("John", "Smith");
        final UG ug = new UG(name, date, null);
        final SmartCard sc = new SmartCard(ug, date, 10);

        assertEquals(name, sc.getName());
        assertEquals(date, sc.getDateOfBirth());

        final SmartCard sc1 = new SmartCard(null, date, 0);
    }

    /**
     * Test method for {@link SmartCard#SmartCard}
     * checking for behaviour when the dateOfIssue is null.
     */
    @Test (expected = NullPointerException.class)
    public final void testConstructorDate() {
        final Date date = new Date();
        final Name name = new Name("John", "Smith");
        final UG ug = new UG(name, date, null);
        final SmartCard sc = new SmartCard(ug, null, 0);
    }

    /**
     * Test method for {@link SmartCard#SmartCard}
     * to ensure card uniqueness is upheld.
     */
    @Test (expected = IllegalArgumentException.class)
    public final void ensureUniqueness() {
        final Date date = new Date();
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int year = cal.get(Calendar.YEAR);

        final Name name = new Name("John", "Smith");
        final Name name2 = new Name("Jack", "Simm");
        final Name name3 = new Name("Davy", "Jones");

        final UG ug = new UG(name, date, null);
        final PGT pgt = new PGT(name2, date, null);
        final PGR pgr = new PGR(name3, date, "test");

        final SmartCard sc = new SmartCard(ug, date, 0);
        final SmartCard sc2 = new SmartCard(ug, date, 1);

        // Check multiple can be assigned.
        assertEquals("JS-"+String.valueOf(year)+"-0", sc.getSmartCardNumber());
        assertEquals("JS-"+String.valueOf(year)+"-1", sc2.getSmartCardNumber());

        final SmartCard sc3 = new SmartCard(pgt, date, 2);
        // Check different types of students can be used.
        assertEquals("JS-"+String.valueOf(year)+"-2", sc3.getSmartCardNumber());

        final SmartCard sc4 = new SmartCard(pgr, date, 0);
        // Check different initials work.
        assertEquals("DJ-"+String.valueOf(year)+"-0", sc4.getSmartCardNumber());

        // Expect exception since pgt initials are "JS" as are ug, and serial with this exists.
        final SmartCard sc5 = new SmartCard(pgt, date, 0);

    }
}
