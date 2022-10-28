package uk.ac.ncl.csc8404.filesys;

/**
 * Module - Class that contains module data and allows it to be accessed
 */
public class Module {
    /*
    Module information is designed to be fetched from a file and
    so should be final. Updating this information is outside
    the scope of this program.
     */
    final String code;
    final String name;
    final int credits;

    /**
     * Constructs a Module object.
     *
     * @param code module code.
     * @param name name of the module.
     * @param credits number of credits associated with the module.
     */
    public Module(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    /**
     * Gets the number of credits associated with the module.
     *
     * @return the number of credits.
     */
    public int getCredits() {
        return this.credits;
    }

    /**
     * Gets the code of the module.
     *
     * @return the module code.
     */
    public String getCode() { return this.code; }

    /**
     * Overrides method to get a user readable output.
     *
     * @return the module in format stored by the university.
     * CODE, NAME, CREDITS
     */
    @Override
    public String toString() {
        return this.code + ", " + this.name + ", " + this.credits;
    }
}
