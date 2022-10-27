package uk.ac.ncl.csc8404.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.ncl.csc8404.stu.*;
import uk.ac.ncl.csc8404.filesys.Module;

import java.util.ArrayList;
import java.util.Date;

/**
 * StudentTest - tests for Student classes: UG, PGT, PGR.
 * As all subclasses share some methods only one type of student
 * class will be tested for those which are not further modified
 * in the subclasses.
 *
 */

public class StudentTest {

    /** Test method for {@link uk.ac.ncl.csc8404.stu.AbstractStudent#AbstractStudent(Name, Date)}
     * Checking constructor (name parameter).
     */
    @Test(expected = NullPointerException.class)
    public final void studentNameConstructor() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG student = new UG(name, dob, null);
        final UG student2 = new UG(null, dob, null);
    }

    /** Test method for {@link uk.ac.ncl.csc8404.stu.AbstractStudent#AbstractStudent(Name, Date)}
     * Checking constructor (dateOfBirth parameter).
     */
    @Test(expected = NullPointerException.class)
    public final void studentDOBConstructor() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG student = new UG(name, dob, null);
        final UG student2 = new UG(name, null, null);
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Student#setID(StudentID)}
     */
    @Test(expected = NullPointerException.class)
    public final void testSetID() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG student = new UG(name, dob, null);
        StudentID id = StudentIDFactory.getInstance("a1234");
        student.setID(id);
        student.setID(null);
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Student#getID()}
     */
    @Test
    public final void testGetID() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG student = new UG(name, dob, null);

        assertNull(student.getID());

        StudentID id = StudentIDFactory.getInstance("b1234");
        student.setID(id);
        assertEquals(id, student.getID());
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Student#getType()}
     */
    @Test
    public final void testGetType() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG ug = new UG(name, dob, null);
        final PGT pgt = new PGT(name, dob, null);
        final PGR pgr = new PGR(name, dob, "test");

        assertEquals("UG", ug.getType());
        assertEquals("PGT", pgt.getType());
        assertEquals("PGR", pgr.getType());
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Student#listModules()}
     * As this method only display to console, testing that there is no
     * exception in the cases is used. The cases tested are:
     * no modules chosen; 1 module chosen; 2 modules chosen.
     */
    @Test(expected = Test.None.class)
    public final void testListModules() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG ug = new UG(name, dob, null);

        ug.listModules();

        final Module module = new Module("ID", "Description", 10);
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(module);
        ug.setChosenModules(modules);

        ug.listModules();

        final Module module2 = new Module("ID2", "Description", 20);
        modules.add(module2);
        ug.setChosenModules(modules);

        ug.listModules();
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Student#getName()}
     */
    @Test
    public final void testGetName() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG ug = new UG(name, dob, null);

        assertEquals(name, ug.getName());
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.Student#getDateOfBirth()}
     * Casting to string is used here instead of overriding the equals method
     * of Date.
     */
    @Test
    public final void testGetDateOfBirth() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG ug = new UG(name, dob, null);

        assertEquals(dob.toString(), ug.getDateOfBirth().toString());
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.AbstractStudent#getCredits()}
     */
    @Test
    public final void testGetCredits() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG ug = new UG(name, dob, null);

        assertEquals(0, ug.getCredits());

        final Module module = new Module("ID", "Description", 10);
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(module);
        ug.setChosenModules(modules);

        assertEquals(10, ug.getCredits());

        final Module module2 = new Module("ID2", "Description", 20);
        modules.add(module2);
        ug.setChosenModules(modules);

        assertEquals(30, ug.getCredits());
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.AbstractStudent#setName(Name)}
     * Casting to string is used as getName returns a defensive copy
     * of the name
     */
    @Test(expected = NullPointerException.class)
    public final void testSetName() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG student = new UG(name, dob, null);

        student.setName(new Name("John", "Doe"));
        assertEquals(new Name("John","Doe"), student.getName());

        student.setName(null);
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.AbstractStudent#setChosenModules(ArrayList)}
     * This also tests {@link uk.ac.ncl.csc8404.stu.AbstractStudent#getChosenModules()} as the
     * getChosenModules method was included for testing.
     */
    @Test
    public final void testSetChosenModules() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG ug = new UG(name, dob, null);

        assertNull(ug.getChosenModules());

        final Module module = new Module("ID", "Description", 10);
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(module);
        ug.setChosenModules(modules);

        assertEquals(modules, ug.getChosenModules());

        final Module module2 = new Module("ID2", "Description", 20);
        modules.add(module2);
        ug.setChosenModules(modules);

        assertEquals(modules, ug.getChosenModules());
    }

    /**
     * The following tests are focused on the specific behaviour implemented
     * by UG, PGT, and PGR.
     */

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.UG#canBeRegistered()}
     */
    @Test
    public final void testUGCanBeRegistered() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final UG ug = new UG(name, dob, null);

        assertFalse(ug.canBeRegistered());

        final Module module = new Module("ID", "Description", 50);
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(module);
        ug.setChosenModules(modules);

        assertFalse(ug.canBeRegistered());

        final Module module2 = new Module("ID2", "Description", 70);
        modules.add(module2);
        ug.setChosenModules(modules);

        assertTrue(ug.canBeRegistered());

        final Module module3 = new Module("ID3", "Description", 10);
        modules.add(module3);
        ug.setChosenModules(modules);

        assertFalse(ug.canBeRegistered());
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.PGT#canBeRegistered()}
     */
    @Test
    public final void testPGTCanBeRegistered() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final PGT pgt = new PGT(name, dob, null);

        assertFalse(pgt.canBeRegistered());

        final Module module = new Module("ID", "Description", 50);
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(module);
        pgt.setChosenModules(modules);

        assertFalse(pgt.canBeRegistered());

        final Module module2 = new Module("ID2", "Description", 130);
        modules.add(module2);
        pgt.setChosenModules(modules);

        assertTrue(pgt.canBeRegistered());

        final Module module3 = new Module("ID3", "Description", 10);
        modules.add(module3);
        pgt.setChosenModules(modules);

        assertFalse(pgt.canBeRegistered());
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.PGR#PGR(Name, Date, String)}
     */
    @Test (expected = NullPointerException.class)
    public final void testGetSupervisorNull() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final PGR pgr = new PGR(name, dob, "Test");

        assertEquals("Test", pgr.getSupervisor());

        final PGR pgr2 = new PGR(name, dob, null);
    }

    /**
     * Test method for {@link uk.ac.ncl.csc8404.stu.PGR#canBeRegistered()}
     */
    @Test
    public final void testPGRCanBeRegistered() {
        final Name name = new Name("John", "Smith");
        final Date dob = new Date();
        final PGR pgr = new PGR(name, dob, "");

        assertFalse(pgr.canBeRegistered());

        final PGR pgr2 = new PGR(name, dob, "test");

        assertTrue(pgr2.canBeRegistered());
    }
}
