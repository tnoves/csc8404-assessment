package uk.ac.ncl.csc8404.stu;

public class UseStudent {
    public static void main(String[] args) {
        StudentID stuID = StudentIDFactory.getInstance("u1234");
        System.out.println(stuID);

        StudentID stuID2 = StudentIDFactory.getInstance("u4321");

        StudentID stuID3 = StudentIDFactory.getInstance("u1234");

    }
}
