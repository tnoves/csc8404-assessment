package uk.ac.ncl.csc8404.stu;

import java.util.ArrayList;
import java.util.Date;

import uk.ac.ncl.csc8404.filesys.Module;
import uk.ac.ncl.csc8404.id.StudentID;

/**
 * AbstractStudent - abstract (partial) implementation of Student (all but
 * canBeRegistered method).
 *
 */

public abstract class AbstractStudent implements Student{
    // The following three fields are not directly accessible to any subclasses.
    private Name name;
    private final Date dateOfBirth;
    private StudentID id;

    // The following two fields can be accessed by subclasses.
    String type;
    ArrayList<Module> chosenModules;

    /**
     * Package-private constructor an abstract student given name and date of birth.
     * Uses defensive copying when assigning name and date of birth.
     *
     * @param name the name of the student.
     * @param dateOfBirth the date of birth of the student.
     * @throws NullPointerException if any parameters are null.
     */
    AbstractStudent(Name name, Date dateOfBirth) {
        if (dateOfBirth == null) {
            throw new NullPointerException("date of birth must not be null");
        }

        setName(name);
        this.dateOfBirth = new Date(dateOfBirth.getTime());
    }

    /**
     * @see uk.ac.ncl.csc8404.stu.Student#setID(StudentID)
     */
    public void setID(StudentID id) {
        if (id == null) {
            throw new NullPointerException("id must not be null");
        }
        else this.id = id;
    }

    /**
     * @see uk.ac.ncl.csc8404.stu.Student#getID()
     */
    public StudentID getID() {
        return id;
    }

    /**
     * @see uk.ac.ncl.csc8404.stu.Student#getType()
     */
    public String getType() {
        return type;
    }

    /**
     * @see uk.ac.ncl.csc8404.stu.Student#getName()
     * Uses defensive copying.
     */
    public Name getName() {
        return new Name(name.getFirstName(), name.getLastName());
    }

    /**
     * @see uk.ac.ncl.csc8404.stu.Student#getDateOfBirth()
     * Uses defensive copying.
     */
    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime());
    }

    /**
     * @see uk.ac.ncl.csc8404.stu.Student#listModules()
     */
    public void listModules() {
        if (chosenModules == null) {
            System.out.println("No modules chosen");
        } else {
            for (Module m : chosenModules) {
                System.out.println(m);
            }
        }
    }

    /**
     * Gets the number of credits currently chosen by the student (as
     * stored in <code>chosenModules</code>).
     *
     * @return the number of credits chosen
     */
    public int getCredits() {
        int credits = 0;
        if (chosenModules == null) {
            return 0;
        }
        for (Module m : chosenModules) {
            credits += m.getCredits();
        }
        return credits;
    }

    /**
     * Allows for changing the student's name after initial object construction.
     * Uses defensive copying.
     *
     * @param name to assign to the student.
     * @throws NullPointerException if <code>name == null</code>
     */
    public void setName(Name name) {
        if (name == null) {
            throw new NullPointerException("name must not be null");
        }
        this.name = new Name(name.getFirstName(), name.getLastName());
    }

    /**
     * Allows for an array of modules to be assigned to the students chosen modules.
     * Uses defensive copying.
     *
     * @param chosenModules an arraylist of Module objects.
     */
    public void setChosenModules(ArrayList<Module> chosenModules) {
        this.chosenModules = new ArrayList<>(chosenModules);
    }

    /**
     * Provides a copy of the modules currently chosen by the student.
     * This is provided for testing.
     *
     * @return an arraylist containing the modules.
     */
    public ArrayList<Module> getChosenModules() {
        if (chosenModules == null) {
            return null;
        }
        return new ArrayList<>(this.chosenModules);
    }
}
