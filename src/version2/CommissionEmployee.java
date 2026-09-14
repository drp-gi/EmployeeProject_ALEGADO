package version2;

public class CommissionEmployee {

    private int empID;
    private Name empName;
    private MyDate dateHired;
    private MyDate birthDate;
    private double totalSale;

    public static final double BIRTHDAY_BONUS = 5000;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = null;
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate dateHired, MyDate birthDate) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
    }

    public CommissionEmployee(int empID, Name empName, MyDate dateHired, MyDate birthDate, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
        this.totalSale = totalSale;
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

    public double computeSalary(int currentMonth) {
        double rate;
        if (totalSale < 50000) {
            rate = 0.05;
        } else if (totalSale < 100000) {
            rate = 0.10;
        } else if (totalSale < 500000) {
            rate = 0.15;
        } else {
            rate = 0.20;
        }

        double salary = totalSale * rate;

        if (birthDate.isSameMonthAs(currentMonth)) {
            salary += BIRTHDAY_BONUS;
        }

        return salary;
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sale: ₱%.2f%n",
                empID, empName, totalSale);
    }

    @Override
    public String toString() {
        return String.format(
                "CommissionEmployee [ID: %d, Name: %s, Total Sale: ₱%.2f, Salary: ₱%.2f]",
                empID, empName, totalSale, computeSalary(9));
    }
}