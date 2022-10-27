package uk.ac.ncl.csc8404.stu;

import java.util.Date;

public interface SmartCardInterface {
    public Name getName();
    public Date getDateOfBirth();
    public StudentID getStudentID();
    public Date getDateOfIssue();
}
