import version2.HourlyEmployee;
import version2.PieceWorkerEmployee;
import version2.CommissionEmployee;
import version2.BasePlusCommissionEmployee;
import version2.Name;
import version2.MyDate;

public class Main2 {
    public static void main(String[] args) {

        int currentMonth = 9; // 24 nights in Spetember

        System.out.println("--- Name & Date Output Verification ---\n");

        HourlyEmployee a = new HourlyEmployee();
            a.setEmpID(101);
            a.setEmpName(new Name("Meow", "Apelyido"));
            a.setDateHired(new MyDate(1, 6, 2020));
            a.setBirthDate(new MyDate(15, 9, 1998)); // sept bday, bonus should hit
            a.setTotalHoursWorked(45);
            a.setRatePerHour(200.0);


        System.out.println("Name:\n" + a.getEmpName());
        System.out.println("Date:\n" + a.getEmpName());

        System.out.println("--- Hourly Employee Payroll Test ---\n");
        HourlyEmployee a2 = new HourlyEmployee(102, new Name("Mark", "R", "Ferrer", "Jr"),
                new MyDate(10, 3, 2019), new MyDate(20, 6, 2000), 38, 180.0);

        //String firstName, String middleName, String lastName, String suffix) {

        System.out.println("[displayHourlyEmployee()]\n");
        a.displayHourlyEmployee();
        a2.displayHourlyEmployee();












        System.out.println(a.getEmpName() + " getter setter check, we outchea\n");



        System.out.println("\n[toString()]\n");
        System.out.println(a);
        System.out.println(a2);



        System.out.println("\nBirthday Incentive Check\n");
        System.out.printf("Regular Month (%d) Salary: %.2f\n", a.getBirthDate().getMonth(), a.computeSalary(9));






    }
}