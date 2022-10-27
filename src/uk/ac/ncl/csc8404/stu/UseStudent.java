package uk.ac.ncl.csc8404.stu;

import java.util.Date;

public class UseStudent {
    public static void main(String[] args) {
        StudentID stuID = StudentIDFactory.getInstance("u1234");
        System.out.println(stuID);
        StudentID stuID2 = StudentIDFactory.getInstance("u1224");
        StudentID stuID3 = StudentIDFactory.getInstance("u1237");

        Date dob = new Date();
        UG ug = new UG(new Name("John", "Smith"), dob, null);
        System.out.println(ug.getName()+" "+ug.getCredits());

        System.out.println(ug.getType());

    }
}
