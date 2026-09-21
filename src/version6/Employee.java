package version6;

import java.util.Objects;

public abstract class Employee implements Cloneable {

    private final int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public static final double BIRTHDAY_BONUS = 5000.00;

    // constructor
    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        if (dateHired == null) throw new NullPointerException("Date hired cannot be null");

        this.empID = empID;
        this.empName = empName.clone();
        this.birthDate = birthDate.clone();
        this.dateHired = dateHired.clone();
    }

    // get employee id
    public final int getEmpID() { return empID; }

    // getters and setters
    public Name getEmpName() { return empName.clone(); }

    public void setEmpName(Name empName) {
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        this.empName = empName.clone();
    }

    public MyDate getBirthDate() { return birthDate.clone(); }

    public void setBirthDate(MyDate birthDate) {
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        this.birthDate = birthDate.clone();
    }

    public MyDate getDateHired() { return dateHired.clone(); }

    public void setDateHired(MyDate dateHired) {
        if (dateHired == null) throw new NullPointerException("Date hired cannot be null");
        this.dateHired = dateHired.clone();
    }

    // calculate birthday bonus
    public final double getBirthdayBonus(int currentMonth) {
        if (birthDate.getMonth() == currentMonth) return BIRTHDAY_BONUS;
        return 0;
    }

    // abstract methods
    public abstract double computeSalary(int currentMonth);
    public abstract double computeSalary();
    public abstract void displayEmployee();

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
    @Override public int hashCode() { return Objects.hash(empID, empName, birthDate, dateHired); }

    // clone employee
    @Override
    public Employee clone() {
        try {
            Employee cloned = (Employee) super.clone();
            cloned.empName = empName.clone();
            cloned.birthDate = birthDate.clone();
            cloned.dateHired = dateHired.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Employee implements Cloneable", e);
        }
    }
}