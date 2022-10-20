package uk.ac.ncl.csc8404.filesys;

public class Module {
    public String code;
    public String name;
    public int credits;

    public Module(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    public int getCredits() {
        return this.credits;
    }

    public String toString() {
        return this.code + ", " + this.name + ", " + this.credits;
    }
}
