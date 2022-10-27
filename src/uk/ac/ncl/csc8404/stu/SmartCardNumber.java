package uk.ac.ncl.csc8404.stu;

public final class SmartCardNumber {
    private String initials;
    private int year;
    private int serial;

    public SmartCardNumber(Student student, int year, int serial) {
        this.initials = String.valueOf(student.getName().getFirstName().charAt(0)
                                        + student.getName().getLastName().charAt(0));
        this.year = year;
        this.serial = serial;
    }

    public String toString() {
        return initials + "-" + year + "-" + serial;
    }
}
