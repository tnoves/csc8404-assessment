package uk.ac.ncl.csc8404.stu;

import java.util.Date;

public class PGR extends AbstractStudent{
    private static final String type = "PGR";
    private final String supervisor;

    public PGR(Name name, Date dateOfBirth, String supervisor) {
        super(name, dateOfBirth);
        if (supervisor.length() == 0) {
            throw new IllegalArgumentException("supervisor must not be empty");
        }
        this.supervisor = supervisor;
    }

    public boolean canBeRegistered() {
        return supervisor.length() != 0;
    }
}
