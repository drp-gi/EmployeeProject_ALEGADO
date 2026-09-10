package version1;

public class HourlyEmployee {

    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empName = "N/A";

    }

    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
    }

    public HourlyEmployee(int empID, String empName, float
            totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }


    public double computeSalary() {

        double excessH;
        double sweldo;


        if (totalHoursWorked <= 40) {
            sweldo = ratePerHour * totalHoursWorked;
        } else {
            excessH = totalHoursWorked - 40;
            double rateIfExceeds = ratePerHour * 1.5;  //is this right

            sweldo = (40 * ratePerHour) + (excessH * rateIfExceeds);


        }
        return sweldo;
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | Hours: %.2f | Rate: %.2f\n", empID, empName, totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format ("HourlyEmployee [EmployeeID: %d, Name: %s, Hours Worked: %.2f, RatePerHour: %.2f, Salary: %.2f]",  empID, empName, totalHoursWorked, ratePerHour, computeSalary());
    }
}
