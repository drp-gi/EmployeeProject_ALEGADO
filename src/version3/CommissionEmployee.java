package version3;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() { return totalSale; }
    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        } else {
            System.out.println("Invalid sale, defaulting to 0.");
            this.totalSale = 0;
        }
    }


    public double getCommissionRate() {
        if (totalSale < 50000) {

            return 0.05; } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalSale * getCommissionRate();
        return basePay + super.computeSalary(currentMonth);
    }

    public void displayCommissionEmployee() {
        super.displayEmployee();
        System.out.printf("Total Sale: ₱%,.2f%n", totalSale);
    }

    @Override
    public String toString() {
        return String.format(
                "CommissionEmployee [%s, Sale: ₱%,.2f, Rate: %.0f%%, Total Salary: ₱%,.2f]",
                super.toString(), totalSale, getCommissionRate() * 100, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CommissionEmployee)) return false;
        if (!super.equals(obj)) return false;
        CommissionEmployee other = (CommissionEmployee) obj;
        return this.totalSale == other.totalSale;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public CommissionEmployee clone() throws CloneNotSupportedException {
        return (CommissionEmployee) super.clone();
    }
}