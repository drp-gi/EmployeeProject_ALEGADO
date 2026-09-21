package version6;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    // constructor
    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    // getters and setters
    public float getTotalHoursWorked() { return totalHoursWorked; }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked < 0) {
            throw new IllegalArgumentException("Total hours worked cannot be negative.");
        }
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() { return ratePerHour; }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour < 0) {
            throw new IllegalArgumentException("Rate per hour cannot be negative.");
        }
        this.ratePerHour = ratePerHour;
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

        return basePay + getBirthdayBonus(currentMonth);
    }

    // calculate salary without month
    @Override public double computeSalary() { return computeSalary(-1); }

    // display employee
    @Override
    public void displayEmployee() {
        System.out.printf("ID: %d | Name: %s | Hours: %.2f | Rate: ₱%.2f/hr%n",
                getEmpID(), getEmpName(), totalHoursWorked, ratePerHour);
    }

    // convert to string
    @Override public String toString() { return String.format("HourlyEmployee [ID: %d, Name: %s, Total Salary: ₱%.2f]", getEmpID(), getEmpName(), computeSalary()); }

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
    @Override public HourlyEmployee clone() { return (HourlyEmployee) super.clone(); }
}