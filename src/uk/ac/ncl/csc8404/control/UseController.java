package uk.ac.ncl.csc8404.control;

import uk.ac.ncl.csc8404.filesys.ModuleRecords;
import uk.ac.ncl.csc8404.stu.Name;
import uk.ac.ncl.csc8404.stu.StudentIDFactory;
import uk.ac.ncl.csc8404.stu.UG;
import uk.ac.ncl.csc8404.filesys.Module;

import java.util.ArrayList;
import java.util.Date;

public class UseController {
    public static void main(String[] args) {
        UniversityController uc = new UniversityController();
        uc.loadModules();
        uc.displayModules();
        System.out.println("END OF SET");

        Date dob = new Date();
        ArrayList<Module> stuMod = new ArrayList<Module>();
        stuMod.add(uc.fetchModule("CSC8201"));
        //stuMod.add(uc.fetchModule("CSC8103"));
        stuMod.add(uc.fetchModule("CSC8406"));

        UG student = new UG(new Name("John", "Smith"), dob, stuMod);
        stuMod.add(uc.fetchModule("CSC8103"));
        student.listModules();
        System.out.println("END OF SET");

        student.setChosenModules(stuMod);
        student.listModules();
        System.out.println("END OF SET");


        uc.registerStudent(student, "a5555");

        UG student2 = new UG(new Name("Jon", "Smit"), dob, stuMod);

        uc.amendStudentData(student.getID(), student2);

        System.out.println(student2.getID());
        System.out.println(uc.noOfStudents("UG"));

        uc.terminateStudent(student.getID());
        System.out.println(uc.noOfStudents("UG"));

        uc.loadSupervisors();
        uc.displaySupervisors();

    }


}
