package uk.ac.ncl.csc8404.stu;

import uk.ac.ncl.csc8404.id.StudentID;
import uk.ac.ncl.csc8404.id.StudentIDFactory;

import java.util.Date;

public class UseStudent {
    public static void main(String[] args) {
        StudentID stuID = StudentIDFactory.makeInstance("u1234");
        System.out.println(stuID);
        StudentID stuID2 = StudentIDFactory.makeInstance("u1224");
        StudentID stuID3 = StudentIDFactory.makeInstance("u1237");

        Date dob = new Date();
        UG ug = new UG(new Name("John", "Smith"), dob, null);
        System.out.println(ug.getName()+" "+ug.getCredits());

        System.out.println(ug.getType());

    }
}
