package uk.ac.ncl.csc8404.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.ac.ncl.csc8404.id.StudentID;
import uk.ac.ncl.csc8404.id.StudentIDFactory;

/**
 * StudentIDTest - tests involving the StudentID and related classes.
 * Testing covers using the StudentIDFactory.
 *
 */

public class StudentIDTest {
    /**
     *  Test methods for {@link StudentIDFactory#makeInstance(String)}
     *  Multiple cases tested.
     *  First section check correct exception is being thrown using cases
     *  of the exception, later tests check some valid inputs and show
     *  no exceptions.
     *
     */

    @Test
    public final void testGetInstance() {
        final StudentID id = StudentIDFactory.makeInstance("a1234");
        assertEquals("a1234", id.toString());

        final StudentID id2 = StudentIDFactory.makeInstance("z9999");
        assertEquals("z9999", id2.toString());
    }

    @Test(expected = NullPointerException.class)
    public final void testNullID() {
        final StudentID id = StudentIDFactory.makeInstance(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testEmptyID() {
        final StudentID id = StudentIDFactory.makeInstance("");
    }

    @Test(expected = IllegalArgumentException.class)
    public final void checkFirstChar() {
        final StudentID id = StudentIDFactory.makeInstance("51234");
    }

    @Test(expected = IllegalArgumentException.class)
    public final void checkDigitsType() {
        final StudentID id3 = StudentIDFactory.makeInstance("c12a4");
    }

    @Test(expected = IllegalArgumentException.class)
    public final void checkDigitsLengthUnder() {
        final StudentID id = StudentIDFactory.makeInstance("a123");
    }
    @Test(expected = IllegalArgumentException.class)
    public final void checkDigitsLengthOver() {
        final StudentID id = StudentIDFactory.makeInstance("a12345");
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testDuplicates() {
        final StudentID id = StudentIDFactory.makeInstance("a4321");
        final StudentID id2 = StudentIDFactory.makeInstance("a4321");
    }

    /**
     * Test method for {@link StudentIDFactory#getLetter()}
     */
    @Test
    public final void testGetLetter() {
        final StudentID id = StudentIDFactory.makeInstance("b5555");
        assertEquals("b", id.getLetter());
    }

    /**
     * Test method for {@link StudentIDFactory#getDigits()}
     */
    @Test
    public final void testGetDigits() {
        final StudentID id = StudentIDFactory.makeInstance("b9090");
        assertEquals("9090", id.getDigits());
    }
}
