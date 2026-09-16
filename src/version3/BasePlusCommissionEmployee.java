package version3;

public class BasePlusCommissionEmployee extends CommissionEmployee {   // woah how does that wrok, ths confusing

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,  double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale); // goes to CommissionEmployee's constructor
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            System.out.println("Invalid base salary, defaulting to 0.");
            this.baseSalary = 0;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        // super.computeSalary(currentMonth) here calls CommissionEmployee's version,
        // which already includes commission pay AND the birthday bonus (via ITS super call)
        return baseSalary + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {
        super.displayCommissionEmployee(); // reuses CommissionEmployee's own display method
        System.out.printf("Base Salary: ₱%,.2f%n", baseSalary);
    }

    @Override
    public String toString() {
        return String.format(
                "BasePlusCommissionEmployee [%s, Base: ₱%,.2f, Total Salary: ₱%,.2f]",
                super.toString(), baseSalary, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BasePlusCommissionEmployee)) return false;
        if (!super.equals(obj)) return false;
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return this.baseSalary == other.baseSalary;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public BasePlusCommissionEmployee clone() throws CloneNotSupportedException {
        return (BasePlusCommissionEmployee) super.clone();
    }
}