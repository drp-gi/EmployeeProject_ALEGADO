package version5;

public class CommissionEmployee extends Employee {

    private double totalSale;

    // default constructor
    public CommissionEmployee() {
        super();
        totalSale = 0;
    }

    // constructor
    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    // getters and setters
    public double getTotalSale() { return totalSale; }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) this.totalSale = totalSale;
        else {
            System.out.println("Invalid sale, defaulting to 0.");
            this.totalSale = 0;
        }
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
        double birthdayBonus = 0;

        if (getBirthDate().isSameMonthAs(currentMonth)) {
            birthdayBonus = BIRTHDAY_BONUS;
        }

        return basePay + birthdayBonus;
    }

    // display employee
    public void displayCommissionEmployee() {
        super.displayEmployee();
        System.out.printf("Total Sale: ₱%,.2f%n", totalSale);
    }

    // convert to string
    @Override public String toString() { return "CommissionEmployee [ID: " + getEmpID() + ", Name: " + getEmpName() + ", Total Salary: ₱" + computeSalary() + "]"; }

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
    @Override public CommissionEmployee clone() throws CloneNotSupportedException { return (CommissionEmployee) super.clone(); }
}