package version3;


import java.util.Objects;

public class Employee implements Cloneable {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public static final double BIRTHDAY_BONUS = 5000.00;     // for easy reading sya

    // Default-like constructor
    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    // Full
    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    // ---------- GETTERS / SETTERS ----------
    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public Name getEmpName() { return empName; }
    public void setEmpName(Name empName) { this.empName = empName; }

    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }

    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }

    // ---------- SALARY ----------
    // Base version: only the birthday bonus lives here.
    // Subclasses will call super.computeSalary(currentMonth) and ADD their own pay on top.
    public double computeSalary(int currentMonth) {
        double bonus = 0;
        if (birthDate.isSameMonthAs(currentMonth)) {
            bonus = BIRTHDAY_BONUS;
        }
        return bonus;
    }

    public double computeSalary() {
        return computeSalary(-1); // -1 never matches a real month, so no bonus
    }

    // ---------- DISPLAY ----------
    public void displayEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s%n",
                empID, empName, birthDate, dateHired);
    }

    @Override
    public String toString() {
        return String.format("Employee [ID: %d, Name: %s, DOB: %s, Hired: %s]",
                empID, empName, birthDate, dateHired);
    }

    // ---------- equals / hashCode ----------
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return this.empID == other.empID
                && this.empName.equals(other.empName)
                && this.birthDate.equals(other.birthDate)
                && this.dateHired.equals(other.dateHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
    }

    // ---------- clone (deep copy) ----------
    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();     // shallow copy first
        cloned.empName = (Name) this.empName.clone();       // then deep-copy the object fields
        cloned.birthDate = (MyDate) this.birthDate.clone();
        cloned.dateHired = (MyDate) this.dateHired.clone();
        return cloned;
    }
}