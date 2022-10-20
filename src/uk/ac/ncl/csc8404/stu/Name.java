package uk.ac.ncl.csc8404.stu;

public class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() == 0) {
            throw new IllegalArgumentException("Empty first name");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() == 0) {
            throw new IllegalArgumentException("Empty last name");
        }
        this.lastName = lastName;
    }
}
