package version5;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    // default constructor
    public HourlyEmployee() {
        super();
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    // constructor
    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    // getters and setters

    public float getTotalHoursWorked() { return totalHoursWorked; }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) this.totalHoursWorked = totalHoursWorked;
        else {
            System.out.println("Invalid hours, defaulting to 0.");
            this.totalHoursWorked = 0;
        }
    }

    public double getRatePerHour() { return ratePerHour; }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) this.ratePerHour = ratePerHour;
        else {
            System.out.println("Invalid rate, defaulting to 0.");
            this.ratePerHour = 0;
        }
    }

    // calculate salary
    @Override
    public double computeSalary(int currentMonth) {

        double basePay;

        if (totalHoursWorked <= 40) {
            basePay = totalHoursWorked * ratePerHour;
        } else {
            double excessHours = totalHoursWorked - 40;
            double overtimeRate = ratePerHour * 1.5;
            basePay = (40 * ratePerHour) + (excessHours * overtimeRate);
        }

        double bonus = 0;

        if (getBirthDate().isSameMonthAs(currentMonth)) {
            bonus = BIRTHDAY_BONUS;
        }

        return basePay + bonus;
    }

    // display employee
    public void displayHourlyEmployee() {
        super.displayEmployee();
        System.out.println("Hours: " + totalHoursWorked + " | Rate: ₱" + ratePerHour + "/hr");
    }

    // convert to string
    @Override public String toString() { return "HourlyEmployee [ID: " + getEmpID() + ", Name: " + getEmpName() + ", Total Salary: ₱" + computeSalary() + "]"; }

    // compare employees
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof HourlyEmployee)) return false;
        if (!super.equals(obj)) return false;

        HourlyEmployee other = (HourlyEmployee) obj;

        return totalHoursWorked == other.totalHoursWorked

                && ratePerHour == other.ratePerHour;
    }

    // create hash code
    @Override public int hashCode() { return java.util.Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour); }

    // clone employee
    @Override public HourlyEmployee clone() throws CloneNotSupportedException { return (HourlyEmployee) super.clone(); }
}