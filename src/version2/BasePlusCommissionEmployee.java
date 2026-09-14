package version2;

public class BasePlusCommissionEmployee {

    private int empID;
    private Name empName;
    private MyDate dateHired;
    private MyDate birthDate;

    private double totalSale;
    private double baseSalary;

    public static final double BIRTHDAY_BONUS = 5000;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = null;
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate dateHired, MyDate birthDate) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate dateHired, MyDate birthDate,
                                      double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }

    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public Name getEmpName() { return empName; }
    public void setEmpName(Name empName) { this.empName = empName; }

    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }

    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }

    public double getTotalSale() { return totalSale; }
    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
    }

    // Same tiered rate logic as version1
    private double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    public double computeSalary(int currentMonth) {
        double commission = totalSale * getCommissionRate();
        double salary = baseSalary + commission;

        if (birthDate.isSameMonthAs(currentMonth)) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sale: ₱%.2f | Base Salary: ₱%.2f%n",
                empID, empName, totalSale, baseSalary);
    }

    @Override
    public String toString() {
        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, Base: ₱%.2f, Sale: ₱%.2f, Rate: %.0f%%, Total Salary: ₱%.2f]",
                empID, empName, baseSalary, totalSale, getCommissionRate() * 100, computeSalary(9));
    }
}