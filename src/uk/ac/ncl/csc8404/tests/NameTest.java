package uk.ac.ncl.csc8404.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import uk.ac.ncl.csc8404.stu.Name;

/**
 * NameTest - Tests for Name  class
 *
 */

public class NameTest {
    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Name#getFirstName()}
     * Name constructor uses setters which throw the errors so initial testing
     * requires a working case.
     */
    @Test
    public final void testGetFirstName() {
        final Name name = new Name("John", "Smith");
        assertEquals("John", name.getFirstName());
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Name#getLastName()}
     * Name constructor uses setters which throw the errors so initial testing
     * requires a working case.
     */
    @Test
    public final void testGetLastName() {
        final Name name = new Name("John", "Smith");
        assertEquals("Smith", name.getLastName());
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Name#setFirstName(String)}
     * Name constructor uses setters which throw the errors so initial testing
     * requires a working case.
     */
    @Test(expected = NullPointerException.class)
    public final void testSetFirstNameAndNull() {
        final Name name = new Name("John", "Smith");
        name.setFirstName("Dave");
        assertEquals("Dave", name.getFirstName());
        name.setFirstName(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public final void testSetFirstNameEmpty() {
        final Name name = new Name("John", "Smith");
        name.setFirstName("");
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Name#setLastName(String)}
     * Name constructor uses setters which throw the errors so initial testing
     * requires a working case.
     */
    @Test(expected = NullPointerException.class)
    public final void testSetLastNameAndNull() {
        final Name name = new Name("John", "Smith");
        name.setLastName("Doe");
        assertEquals("Doe", name.getLastName());
        name.setLastName(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public final void testSetLastNameEmpty() {
        final Name name = new Name("John", "Smith");
        name.setLastName("");
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Name#toString()}
     */
    @Test
    public final void testToString() {
        final Name name = new Name("John", "Smith");
        assertEquals("John Smith", name.toString());
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Name#equals(Object)}
     */
    @Test
    public final void testEquals() {
        final Name name = new Name("John", "Smith");
        final Name name2 = new Name("John", "Smith");
        final Name name3 = new Name("John", "Doe");

        assertEquals(name, name2);
        assertNotEquals(name, name3);
    }
}
