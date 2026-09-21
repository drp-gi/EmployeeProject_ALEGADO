package version6;


public final class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    // constructor
    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    // getters and setters
    public double getBaseSalary() { return baseSalary; }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) throw new IllegalArgumentException("Base salary cannot be negative.");
        this.baseSalary = baseSalary;
    }

    // calculate salary
    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    // calculate salary without month
    @Override public double computeSalary() { return computeSalary(-1); }

    // display employee
    @Override
    public void displayEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sale: ₱%.2f | Base Salary: ₱%.2f%n",
                getEmpID(), getEmpName(), getTotalSale(), baseSalary);
    }

    // convert to string
    @Override public String toString() { return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%.2f]", getEmpID(), getEmpName(), computeSalary()); }

    // compare employees
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BasePlusCommissionEmployee)) return false;
        if (!super.equals(obj)) return false;

        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return baseSalary == other.baseSalary;
    }

    // create hash code
    @Override public int hashCode() { return java.util.Objects.hash(super.hashCode(), baseSalary); }

    // clone employee
    @Override public BasePlusCommissionEmployee clone() { return (BasePlusCommissionEmployee) super.clone(); }
}