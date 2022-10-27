package uk.ac.ncl.csc8404.control;

import uk.ac.ncl.csc8404.filesys.Module;
import uk.ac.ncl.csc8404.filesys.ModuleRecords;
import uk.ac.ncl.csc8404.filesys.SupervisorRecords;
import uk.ac.ncl.csc8404.stu.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class UniversityController implements MainInterface{
    private static final Map<StudentID, Student>  registeredStudents = new HashMap<StudentID, Student>();
    private static final Map<StudentID, SmartCardNumber> smartCards = new HashMap<StudentID, SmartCardNumber>();

    private ArrayList<Module> modules = new ArrayList<Module>();
    private static final Map<String, Module> modulesMap = new HashMap<String, Module>();

    private ArrayList<String> supervisors = new ArrayList<String>();

    public int noOfStudents(String typeOfStudent) {
        int counter = 0;
        for (StudentID id : registeredStudents.keySet()) {
            if (registeredStudents.get(id).getType() == typeOfStudent) {
                counter++;
            }
        }
        return counter;
    }

    public void registerStudent(Student student, String idString) {
        if (student.canBeRegistered()) {
            StudentID id = StudentIDFactory.getInstance(idString);
            student.setID(id);
            registeredStudents.put(id, student);
            System.out.println("Registered student");
        } else {
            System.out.println("Student cannot be registered");
        }
    }

    public void amendStudentData(StudentID id, AbstractStudent studentData) {
        studentData.setID(id);
        registeredStudents.replace(id, studentData);
    }

    public void terminateStudent(StudentID id) {
        registeredStudents.remove(id);
    }

    public void issueSmartCard(StudentID id) {

    }

    public void loadModules() {
        ModuleRecords mr = new ModuleRecords();
        modules = mr.getModules(mr.readFile("src/uk/ac/ncl/csc8404/filesys/files/modules.txt"));
        for (Module m : modules) {
            modulesMap.put(m.getCode(), m);
        }
    }

    public void displayModules() {
        for (String code : modulesMap.keySet()) {
            System.out.println(modulesMap.get(code));
        }
    }

    public Module fetchModule(String code) {
        return modulesMap.get(code);
    }

    public void loadSupervisors() {
        SupervisorRecords sr = new SupervisorRecords();
        supervisors = sr.readFile("src/uk/ac/ncl/csc8404/filesys/files/supervisors.txt");
    }

    public void displaySupervisors() {
        for (String s : supervisors) {
            System.out.println(s);
        }
    }
}
