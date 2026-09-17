package version4;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;


    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }


    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    // getters / setters
    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        } else {
            System.out.println("Invalid hours, defaulting to 0.");
            this.totalHoursWorked = 0;
        }
    }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        } else {
            System.out.println("Invalid rate, defaulting to 0.");
            this.ratePerHour = 0;
        }
    }

    // salary
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
        return basePay + super.computeSalary(currentMonth);
    }

    // display
    public void displayHourlyEmployee() {
        super.displayEmployee(); // reuse the parent's printing of ID/name/DOB/hired
        System.out.printf("Hours: %.2f | Rate: ₱%.2f/hr%n", totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee [%s, Hours: %.2f, Rate: ₱%.2f, Total Salary: ₱%,.2f]",
                super.toString(), totalHoursWorked, ratePerHour, computeSalary());
    }

    // ---------- equals / hashCode / clone ----------
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HourlyEmployee)) return false;
        if (!super.equals(obj)) return false; // check empID/empName/dates first
        HourlyEmployee other = (HourlyEmployee) obj;
        return this.totalHoursWorked == other.totalHoursWorked
                && this.ratePerHour == other.ratePerHour;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() throws CloneNotSupportedException {
        return (HourlyEmployee) super.clone();
    }
}