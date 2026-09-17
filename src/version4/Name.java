package version4;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "";
    }




    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }



    public void displayName() {
        System.out.println(this.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;         // if not of name enddd it
        Name other = (Name) obj;                          //
        return this.firstName.equalsIgnoreCase(other.firstName)
                && this.middleName.equalsIgnoreCase(other.middleName)
                && this.lastName.equalsIgnoreCase(other.lastName)
                && this.suffix.equalsIgnoreCase(other.suffix);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, middleName, lastName, suffix);
    }

    @Override
    public Name clone() throws CloneNotSupportedException {
        return (Name) super.clone();
    }

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