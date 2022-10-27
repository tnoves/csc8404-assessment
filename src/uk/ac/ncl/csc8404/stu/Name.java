package uk.ac.ncl.csc8404.stu;

/**
 * Name - a mutable representation of a name.
 *
 */

public class Name {
    private String firstName;
    private String lastName;

    /**
     * Constructs a name from provided first and last names.
     *
     * @param firstName first name.
     * @param lastName surname.
     * @throws NullPointerException if either provided names are null.
     * @throws IllegalArgumentException if either provided names are empty
     */
    public Name(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     * @param firstName the first name.
     * @throws NullPointerException if firstName is null.
     * @throws IllegalArgumentException if firstName is empty.
     */
    public void setFirstName(String firstName) {
        if (firstName.length() == 0) {
            throw new IllegalArgumentException("Empty first name");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     * @param lastName the first name.
     * @throws NullPointerException if lastName is null.
     * @throws IllegalArgumentException if lastName is empty.
     */
    public void setLastName(String lastName) {
        if (lastName.length() == 0) {
            throw new IllegalArgumentException("Empty last name");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Name))
            return false;

        final Name name = (Name) obj;

        return firstName.equals(name.firstName)
                && lastName.equals(lastName);
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hc = 51;

        hc = 29 * hc + firstName.hashCode();

        return 29 * hc + lastName.hashCode();
    }
}
