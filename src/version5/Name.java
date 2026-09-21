package version5;

public class Name implements Cloneable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    // constructor
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        middleName = "";
        this.lastName = lastName;
        suffix = "";
    }

    // default constructor
    public Name() {
        firstName = "N/A";
        middleName = "N/A";
        lastName = "N/A";
        suffix = "";
    }

    // constructor
    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    // constructor
    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        suffix = "";
    }

    // getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getSuffix() { return suffix; }
    public void setSuffix(String suffix) { this.suffix = suffix; }

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
                && middleName.equalsIgnoreCase(other.middleName)
                && lastName.equalsIgnoreCase(other.lastName)
                && suffix.equalsIgnoreCase(other.suffix);
    }

    // create hash code
    @Override public int hashCode() { return java.util.Objects.hash(firstName, middleName, lastName, suffix); }

    // clone name
    @Override public Name clone() throws CloneNotSupportedException { return (Name) super.clone(); }

    // convert to string
    @Override
    public String toString() {
        String result = lastName + ", " + firstName;

        if (middleName != null && !middleName.isEmpty()) {
            result += " " + middleName.charAt(0) + ".";
        }

        if (suffix != null && !suffix.isEmpty()) {
            result += " " + suffix;
        }

        return result;
    }
}