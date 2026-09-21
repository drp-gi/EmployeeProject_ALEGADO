package version5;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    // default constructor
    public BasePlusCommissionEmployee() {
        super();
        baseSalary = 0;
    }

    // constructor
    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    // getters and setters
    public double getBaseSalary() { return baseSalary; }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) this.baseSalary = baseSalary;
        else {
            System.out.println("Invalid base salary, defaulting to 0.");
            this.baseSalary = 0;
        }
    }

    // calculate salary
    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    // display employee
    public void displayBasePlusCommissionEmployee() {
        super.displayCommissionEmployee();
        System.out.printf("Base Salary: ₱%,.2f%n", baseSalary);
    }

    // convert to string
    @Override public String toString() { return "BasePlusCommissionEmployee [ID: " + getEmpID() + ", Name: " + getEmpName() + ", Total Salary: ₱" + computeSalary() + "]"; }

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
    @Override public BasePlusCommissionEmployee clone() throws CloneNotSupportedException { return (BasePlusCommissionEmployee) super.clone(); }
}