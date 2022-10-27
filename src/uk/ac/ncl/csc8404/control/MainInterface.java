package uk.ac.ncl.csc8404.control;

import uk.ac.ncl.csc8404.stu.AbstractStudent;
import uk.ac.ncl.csc8404.stu.Student;
import uk.ac.ncl.csc8404.stu.StudentID;

public interface MainInterface {
    int noOfStudents(String typeOfStudent);
    void registerStudent(Student student, String idString);
    void amendStudentData(StudentID id, AbstractStudent studentData);
    void terminateStudent(StudentID id);

}
