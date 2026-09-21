package version6;

public final class Name implements Cloneable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    // constructor
    public Name(String firstName, String lastName) {
        this(firstName, "", lastName, "");
    }

    // constructor
    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    // constructor
    public Name(String firstName, String middleName, String lastName, String suffix) {
        validateRequired(firstName);
        validateRequired(lastName);

        this.firstName = firstName;

        if (middleName == null) this.middleName = "";
        else this.middleName = middleName;

        this.lastName = lastName;

        if (suffix == null) this.suffix = ""; else this.suffix = suffix;
    }

    // check required name
    private static void validateRequired(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
    }

    // getters and setters
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        validateRequired(firstName);
        this.firstName = firstName;
    }

    public String getMiddleName() { return middleName; }

    public void setMiddleName(String middleName) {
        if (middleName == null) this.middleName = "";
        else this.middleName = middleName;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) {
        validateRequired(lastName);
        this.lastName = lastName;
    }

    public String getSuffix() { return suffix; }

    public void setSuffix(String suffix) {
        if (suffix == null) this.suffix = "";
        else this.suffix = suffix;
    }

    // display name
    public void displayName() {
        System.out.println(this);
    }

    // compare names
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;

        Name other = (Name) obj;

        return firstName.equalsIgnoreCase(other.firstName)
                && middleName.equalsIgnoreCase(other.middleName) && lastName.equalsIgnoreCase(other.lastName)
                && suffix.equalsIgnoreCase(other.suffix);
    }

    // create hash code
    @Override public int hashCode() { return java.util.Objects.hash(firstName, middleName, lastName, suffix); }

    // clone name
    @Override public Name clone() { return new Name(firstName, middleName, lastName, suffix); }

    // convert to string
    @Override
    public String toString() {
        String result = lastName + ", " + firstName;

        if (!middleName.isEmpty()) {
            result += " " + middleName.charAt(0) + ".";
        }

        if (!suffix.isEmpty()) {
            result += " " + suffix;
        }

        return result;
    }
}