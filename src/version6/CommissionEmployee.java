package version6;

public class CommissionEmployee extends Employee {

    private double totalSale;

    // constructor
    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    // getters and setters
    public double getTotalSale() { return totalSale; }

    public void setTotalSale(double totalSale) {
        if (totalSale < 0) throw new IllegalArgumentException("Total sale cannot be negative.");
        this.totalSale = totalSale;
    }

    // get commission rate
    public double getCommissionRate() {
        if (totalSale < 50000) return 0.05;
        else if (totalSale < 100000) return 0.10;
        else if (totalSale < 500000) return 0.15;
        else return 0.20;
    }

    // calculate salary
    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalSale * getCommissionRate();
        return basePay + getBirthdayBonus(currentMonth);
    }

    // calculate salary without month
    @Override public double computeSalary() { return computeSalary(-1); }

    // display employee
    @Override
    public void displayEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sale: ₱%.2f%n", getEmpID(), getEmpName(), totalSale);
    }

    // convert to string
    @Override public String toString() { return String.format("CommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%.2f]", getEmpID(), getEmpName(), computeSalary()); }

    // compare employees
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CommissionEmployee)) return false;
        if (!super.equals(obj)) return false;

        CommissionEmployee other = (CommissionEmployee) obj;
        return totalSale == other.totalSale;
    }

    // create hash code
    @Override public int hashCode() { return java.util.Objects.hash(super.hashCode(), totalSale); }

    // clone employee
    @Override public CommissionEmployee clone() { return (CommissionEmployee) super.clone(); }
}