package version5;

import java.util.Objects;

public class Employee implements Cloneable {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public static final double BIRTHDAY_BONUS = 5000.00;

    // default constructor
    public Employee() {
        empID = 0;
        empName = new Name();
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    // constructor
    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    // getters and setters

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    // salary

    public double computeSalary(int currentMonth) {
        return 0.0;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    // display employee

    public void displayEmployee() {
        System.out.println("ID: " + empID + " | Name: " + empName + " | DOB: " + birthDate + " | Hired: " + dateHired);
    }

    // convert employee to string

    @Override
    public String toString() {
        return "Employee [ID: " + empID + ", Name: " + empName + ", DOB: " + birthDate
                + ", Hired: " + dateHired + "]";
    }

    // compare employees

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Employee)) return false;

        Employee other = (Employee) obj;

        return empID == other.empID
                && empName.equals(other.empName)
                && birthDate.equals(other.birthDate)
                && dateHired.equals(other.dateHired);
    }

    // create hash code

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
    }

    // clone employee

    @Override
    public Employee clone() throws CloneNotSupportedException {

        Employee cloned = (Employee) super.clone();

        cloned.empName = (Name) empName.clone();
        cloned.birthDate = (MyDate) birthDate.clone();
        cloned.dateHired = (MyDate) dateHired.clone();

        return cloned;
    }
}