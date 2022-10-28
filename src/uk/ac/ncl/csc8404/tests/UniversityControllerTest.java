package uk.ac.ncl.csc8404.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uk.ac.ncl.csc8404.control.MainInterface;
import uk.ac.ncl.csc8404.control.UniversityController;
import uk.ac.ncl.csc8404.id.StudentID;
import uk.ac.ncl.csc8404.id.StudentIDFactory;
import uk.ac.ncl.csc8404.stu.*;
import uk.ac.ncl.csc8404.filesys.Module;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/** UniversityControllerTest - Test for functionality
 * of the Controller interface. Other tests exists for
 * the interfaces / classes used by the UniversityController.
 *
 * These tests need to be run separately due to the use of static variables
 * in the classes.
 * testNoOfStudents, testAmendStudentData, and testTerminateStudent are
 * expected to give errors if run together.
 */

public class UniversityControllerTest {


    /**
     * Method to test {@link uk.ac.ncl.csc8404.control.MainInterface#registerStudent(Student, String)}
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testRegisterStudent() {
        final UniversityController uc = new UniversityController();
        uc.loadModules();
        uc.loadSupervisors();

        final Name name = new Name("John", "Smith");
        final Date dob = new Date();

        // Fail registration - no modules
        final UG ug = new UG (name, dob, null);
        uc.registerStudent(ug, "a1234");
        assertEquals(0, uc.noOfStudents("UG"));

        // Successful registration
        final ArrayList<Module> stuMod = new ArrayList<Module>();
        stuMod.add(uc.fetchModule("CSC8201"));
        stuMod.add(uc.fetchModule("CSC8404"));
        stuMod.add(uc.fetchModule("CSC8103"));

        ug.setChosenModules(stuMod);
        uc.registerStudent(ug, "a1234");
        assertEquals(1, uc.noOfStudents("UG"));

        // Successful registration with different student type.
        final PGR pgr = new PGR(name, dob, "test");
        uc.registerStudent(pgr, "a4321");
        assertEquals(1, uc.noOfStudents("PGR"));

        // Failed registration with duplicated id
        final PGR pgr2 = new PGR(name, dob, "test2");
        uc.registerStudent(pgr, "a1234");
    }

    /**
     * Method to test {@link uk.ac.ncl.csc8404.control.MainInterface#noOfStudents}
     * All types of student use same method so redundant
     * to test all student types.
     */
    @Test
    public final void testNoOfStudents() {
        final UniversityController uc = new UniversityController();
        uc.loadModules();
        uc.loadSupervisors();

        final Name name = new Name("John", "Smith");
        final Date dob = new Date();

        // Test for none
        assertEquals(0, uc.noOfStudents("UG"));
        assertEquals(0, uc.noOfStudents("PGT"));
        assertEquals(0, uc.noOfStudents("PGR"));

        // Test for one
        final UG ug = new UG (name, dob, null);
        final ArrayList<Module> stuMod = new ArrayList<Module>();
        stuMod.add(uc.fetchModule("CSC8201"));
        stuMod.add(uc.fetchModule("CSC8404"));
        stuMod.add(uc.fetchModule("CSC8103"));

        ug.setChosenModules(stuMod);
        uc.registerStudent(ug, "a1234");

        assertEquals(1, uc.noOfStudents("UG"));

        // Test for two
        final UG ug2 = new UG (name, dob, null);
        ug2.setChosenModules(stuMod);
        uc.registerStudent(ug2, "a1235");

        assertEquals(2, uc.noOfStudents("UG"));
    }

    /**
     * Method to test {@link uk.ac.ncl.csc8404.control.MainInterface#amendStudentData}
     * Check that the only way to modifier a students
     * data is through the interface.
     */
    @Test
    public final void testAmendStudentData() {
        final UniversityController uc = new UniversityController();
        uc.loadModules();
        uc.loadSupervisors();

        final Name name = new Name("John", "Smith");
        final Date dob = new Date();

        final UG ug = new UG (name, dob, null);
        final ArrayList<Module> stuMod = new ArrayList<Module>();
        stuMod.add(uc.fetchModule("CSC8201"));
        stuMod.add(uc.fetchModule("CSC8404"));
        stuMod.add(uc.fetchModule("CSC8103"));

        ug.setChosenModules(stuMod);
        uc.registerStudent(ug, "a1234");

        // Test name is stored
        assertEquals("John Smith", ug.getName().toString());

        // Test name doesn't get overwritten by modifying object.
        name.setFirstName("Bob");
        assertEquals("John Smith", ug.getName().toString());

        // Test amending name
        final UG newDataUg = new UG(name, dob, stuMod);
        uc.amendStudentData(ug.getID(), newDataUg);
        assertEquals("Bob Smith", uc.getStudent(ug.getID()).getName().toString());

    }

    /**
     * Method to test {@link uk.ac.ncl.csc8404.control.MainInterface#terminateStudent}
     * Ensure that a terminated student is no longer
     * in the registered student map and that their
     * student id can be reused.
     */
    @Test
    public final void testTerminateStudent() {
        final UniversityController uc = new UniversityController();
        uc.loadModules();
        uc.loadSupervisors();

        final Name name = new Name("John", "Smith");
        final Date dob = new Date();

        final UG ug = new UG (name, dob, null);
        final ArrayList<Module> stuMod = new ArrayList<Module>();
        stuMod.add(uc.fetchModule("CSC8201"));
        stuMod.add(uc.fetchModule("CSC8404"));
        stuMod.add(uc.fetchModule("CSC8103"));

        ug.setChosenModules(stuMod);
        uc.registerStudent(ug, "a1234");

        // Check student exists
        assertEquals(1, uc.noOfStudents("UG"));

        uc.terminateStudent(ug.getID());

        assertEquals(0, uc.noOfStudents("UG"));

        // Ensure student id has been successfully removed
        uc.registerStudent(ug, "a1234");
        assertEquals(1, uc.noOfStudents("UG"));
    }

    /**
     * Method to test {@link uk.ac.ncl.csc8404.control.UniversityController#issueSmartCard}
     * Checking how age conditions are handled.
     */
    @Test (expected = IllegalArgumentException.class)
    public final void testIssueSmartCard() {
        final UniversityController uc = new UniversityController();
        uc.loadModules();
        uc.loadSupervisors();

        final Name name = new Name("John", "Smith");
        final Date date = new Date();
        final ArrayList<Module> stuMod = new ArrayList<Module>();
        stuMod.add(uc.fetchModule("CSC8201"));
        stuMod.add(uc.fetchModule("CSC8404"));
        stuMod.add(uc.fetchModule("CSC8103"));

        final Calendar from = Calendar.getInstance();
        final Calendar current = Calendar.getInstance();
        // Set student to be above threshold for card
        from.set(Calendar.YEAR, current.get(Calendar.YEAR) - 18);

        final UG ug = new UG (name, from.getTime(), stuMod);
        uc.registerStudent(ug, "a1234");
        uc.issueSmartCard(ug.getID(), 0);

        // Test for successful smartcard issuing when age > threshold
        assertEquals("JS-"+current.get(Calendar.YEAR)+"-0", uc.getSmartcard(ug.getID()).getSmartCardNumber());

        from.set(Calendar.YEAR, current.get(Calendar.YEAR) - 17);
        final UG ug2 = new UG (name, from.getTime(), stuMod);
        uc.registerStudent(ug2, "a1235");
        uc.issueSmartCard(ug2.getID(), 1);

        // Test for successful smartcard issuing when age = threshold
        assertEquals("JS-"+current.get(Calendar.YEAR)+"-1", uc.getSmartcard(ug2.getID()).getSmartCardNumber());

        // Expect exception as age < threshold
        from.set(Calendar.YEAR, current.get(Calendar.YEAR) - 16);
        final UG ug3 = new UG (name, from.getTime(), stuMod);
        uc.registerStudent(ug2, "a1236");
        uc.issueSmartCard(ug2.getID(), 1);
    }

    /**
     * Method to test {@link uk.ac.ncl.csc8404.control.UniversityController#issueSmartCard}
     * Checking how duplicates are handled.
     **/
    @Test (expected = IllegalArgumentException.class)
    public final void testIssueSmartCardDuplicates() {
        final UniversityController uc = new UniversityController();
        uc.loadModules();
        uc.loadSupervisors();

        final Name name = new Name("John", "Smith");
        final Date date = new Date();
        final ArrayList<Module> stuMod = new ArrayList<Module>();
        stuMod.add(uc.fetchModule("CSC8201"));
        stuMod.add(uc.fetchModule("CSC8404"));
        stuMod.add(uc.fetchModule("CSC8103"));

        final Calendar from = Calendar.getInstance();
        final Calendar current = Calendar.getInstance();
        // Set student to be above threshold for card
        from.set(Calendar.YEAR, current.get(Calendar.YEAR) - 18);

        final UG ug = new UG (name, from.getTime(), stuMod);
        uc.registerStudent(ug, "a1234");
        uc.issueSmartCard(ug.getID(), 0);

        final UG ug2 = new UG(name, from.getTime(), stuMod);
        uc.registerStudent(ug2, "a1234");
        // Attempt to produce existing smartcard number
        uc.issueSmartCard(ug2.getID(), 0);
    }
}
