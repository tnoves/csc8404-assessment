package uk.ac.ncl.csc8404.control;

import uk.ac.ncl.csc8404.card.SmartCard;
import uk.ac.ncl.csc8404.card.SmartCardNumberFactory;
import uk.ac.ncl.csc8404.filesys.Module;
import uk.ac.ncl.csc8404.filesys.ModuleRecords;
import uk.ac.ncl.csc8404.filesys.SupervisorRecords;
import uk.ac.ncl.csc8404.id.StudentID;
import uk.ac.ncl.csc8404.id.StudentIDFactory;
import uk.ac.ncl.csc8404.stu.*;

import java.util.*;

/**
 * UniversityController - implementation of the MainInterface with
 * additional functionality in order to produce/register students
 * and interact with module and supervisor datafiles.
 */

public final class UniversityController implements MainInterface{
    /*
    These two objects store a map linking student id's to the student
    for those that are registered, and student id's to smart card numbers
    for those with smart cards.
     */
    private static final Map<StudentID, Student>  registeredStudents = new HashMap<StudentID, Student>();
    private static final Map<StudentID, SmartCard> smartCards = new HashMap<StudentID, SmartCard>();

    // Mop modules to enable easier construction of chosen modules for students.
    private ArrayList<Module> modules = new ArrayList<Module>();
    private static final Map<String, Module> modulesMap = new HashMap<String, Module>();

    // Store supervisor names in a list for easier access when constructing PGR students.
    private ArrayList<String> supervisors = new ArrayList<String>();

    /**
     * @see uk.ac.ncl.csc8404.control.MainInterface#noOfStudents(String)
     */
    public int noOfStudents(String typeOfStudent) {
        int counter = 0;
        for (StudentID id : registeredStudents.keySet()) {
            if (registeredStudents.get(id).getType() == typeOfStudent) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * @see uk.ac.ncl.csc8404.control.MainInterface#registerStudent(Student, String)
     */
    public void registerStudent(Student student, String idString) {
        if (student.canBeRegistered()) {
            StudentID id = StudentIDFactory.makeInstance(idString);
            student.setID(id);
            registeredStudents.put(id, student);
            System.out.println("Registered student");
        } else {
            System.out.println("Student cannot be registered");
        }
    }

    /**
     * @see uk.ac.ncl.csc8404.control.MainInterface#amendStudentData(StudentID, AbstractStudent)
     */
    public void amendStudentData(StudentID id, AbstractStudent studentData) {
        studentData.setID(id);
        registeredStudents.replace(id, studentData);
    }


    /**
     * @see uk.ac.ncl.csc8404.control.MainInterface#terminateStudent(StudentID) 
     */
    public void terminateStudent(StudentID id) {
        registeredStudents.remove(id);
    }

    /**
     * Method to issue a smartcard to a student if conditions are met.
     * If successful, the smartcard is mapped to the student's id.
     * @param id the id of the student to generate a smartcard
     *           for.
     * @param serial an arbitrary serial for the id.
     * @throws NullPointerException if a matching student is not registered.
     * @throws IllegalArgumentException if the smartcard number
     * generated already exists in the system or the conditions are not met
     * for issuing.
     */
    public void issueSmartCard(StudentID id, int serial) throws NullPointerException {
        if (registeredStudents.get(id) == null) {
            throw new NullPointerException("No student with this id exists");
        }
        Student student = registeredStudents.get(id);

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.setTime(student.getDateOfBirth());
        to.setTime(new Date());
        int age = to.get(Calendar.YEAR) - from.get(Calendar.YEAR);


        if (student.getType().equals("UG")
                && age >= 17
                && smartCards.get(id) == null) {
            SmartCard sc = new SmartCard(student, new Date(), serial);
            smartCards.put(id, sc);
        } else if ((student.getType().equals("PGT") || student.getType().equals("PGR"))
                && age >= 20
                && smartCards.get(id) == null) {
            SmartCard sc = new SmartCard(student, new Date(), serial);
            smartCards.put(id, sc);
        } else {
            throw new IllegalArgumentException("conditions not met for issuing smart card");
        }
    }

    /**
     * Method to load modules from a file formatted
     * CODE, TITLE, CREDITS
     * on each line into a map. This expects the user to
     * have provided a 'modules.txt' file in the 'files'
     * directory of filesys.
     */
    public void loadModules() {
        ModuleRecords mr = new ModuleRecords();
        modules = mr.getModules(mr.readFile("src/uk/ac/ncl/csc8404/filesys/files/modules.txt"));
        for (Module m : modules) {
            modulesMap.put(m.getCode(), m);
        }
    }

    /**
     * Method to display all modules currently loaded into the program.
     * Designed to be used to get the module codes easily to add them
     * to a students chosen modules.
     */
    public void displayModules() {
        for (String code : modulesMap.keySet()) {
            System.out.println(modulesMap.get(code));
        }
    }

    /**
     * Method to fetch the Module object from the map of loaded
     * modules.
     * @param code a code relating to a module in the mapping.
     * @return the Module object mapped to the code, otherwise
     * null if no Module matches.
     */
    public Module fetchModule(String code) {
        return modulesMap.get(code);
    }


    /**
     * Method to load supervisors from a file formatted
     * SUPERVISOR NAME
     * on each line into an array. This expects the user to
     * have provided a 'supervisors.txt' file in the 'files'
     * directory of filesys.
     */
    public void loadSupervisors() {
        SupervisorRecords sr = new SupervisorRecords();
        supervisors = sr.readFile("src/uk/ac/ncl/csc8404/filesys/files/supervisors.txt");
    }


    /**
     * Method to display all supervisors currently loaded
     * into the program. Designed to be used to easily view
     * all supervisors to construct PGR students with.
     */
    public void displaySupervisors() {
        for (String s : supervisors) {
            System.out.println(s);
        }
    }
}
