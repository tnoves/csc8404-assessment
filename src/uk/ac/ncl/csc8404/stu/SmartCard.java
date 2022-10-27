package uk.ac.ncl.csc8404.stu;

import java.util.Date;

public class SmartCard implements SmartCardInterface {
    private Student student;
    private Date dateOfIssue;
    private Date expiryOfExpiry;

    public SmartCard(Student student) {
        this.student = student;
    }

    public Name getName() {
        return student.getName();
    }

    public Date getDateOfBirth() {
        return student.getDateOfBirth();
    }

    public StudentID getStudentID() {
        return student.getID();
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }
}
