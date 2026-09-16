package version2;

public class HourlyEmployee {

    private int empID;
    private Name empName;
    private MyDate dateHired;
    private MyDate birthDate;
    private float totalHoursWorked;
    private double ratePerHour;

    public static final double BIRTHDAY_BONUS = 5000;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.dateHired = new MyDate();
        this.birthDate = new MyDate();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate dateHired, MyDate birthDate) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
    }

    public HourlyEmployee(int empID, Name empName, MyDate dateHired, MyDate birthDate,
                          float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public Name getEmpName() { return empName; }
    public void setEmpName(Name empName) { this.empName = empName; }

    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }

    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) { this.totalHoursWorked = totalHoursWorked; }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double ratePerHour) { this.ratePerHour = ratePerHour; }

    public double computeSalary(int currentMonth) {

        double excessH;
        double sweldo;

        if (totalHoursWorked <= 40) {
            sweldo = ratePerHour * totalHoursWorked;
        } else {
            excessH = totalHoursWorked - 40;
            double rateIfExceeds = ratePerHour * 1.5;

            sweldo = (40 * ratePerHour) + (excessH * rateIfExceeds);
        }

        if (birthDate.isSameMonthAs(currentMonth)) {
            sweldo += BIRTHDAY_BONUS;
        }

        return sweldo;
    }


    public double computeSalary() {
        return computeSalary(0);
    }



    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Hours: %.2f | Rate: ₱%.2f/hr%n",
                empID, empName, birthDate, dateHired, totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Hours: %.2f, Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
                empID, empName, birthDate, dateHired, totalHoursWorked, ratePerHour, computeSalary());
    }
}