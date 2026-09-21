package version5;

public class Main5 {

    public static void main(String[] args) {

        // create roster
        EmployeeRoster roster = new EmployeeRoster();

        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("====================================================================");

        // add hourly employee
        HourlyEmployee he1 = new HourlyEmployee(
                101, new Name("Alice", "M.", "Smith"),
                new MyDate(14, 9, 1995), new MyDate(1, 6, 2020),
                45f, 300.0);

        roster.addEmployee(he1);
        System.out.println("Enrolled: " + he1.getEmpName() + " (Hourly)");

        // add piece worker employee
        PieceWorkerEmployee pwe1 = new PieceWorkerEmployee(
                201, new Name("Bob", "C.", "Jones", "Jr."),
                new MyDate(3, 4, 1990), new MyDate(15, 1, 2021),
                135, 30.0);

        roster.addEmployee(pwe1);
        System.out.println("Enrolled: " + pwe1.getEmpName() + " (Piece Worker)");

        // add commission employee
        CommissionEmployee ce1 = new CommissionEmployee(
                301, new Name("Maria", "L.", "Reyes"), new MyDate(20, 9, 1988), new MyDate(10, 3, 2019),
                100000.0);

        roster.addEmployee(ce1);
        System.out.println("Enrolled: " + ce1.getEmpName() + " (Commission)");

        // add base plus commission employee
        BasePlusCommissionEmployee bpce1 = new BasePlusCommissionEmployee(401, new Name("Kevin", "S.", "Tan"), new MyDate(11, 2, 1992), new MyDate(5, 7, 2018),
                80000.0, 20000.0);

        roster.addEmployee(bpce1);
        System.out.println("Enrolled: " + bpce1.getEmpName() + " (Base Plus Commission)");

        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");

        // display payroll
        System.out.println("\n======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        roster.displayPayroll(9);

        // display employee counts
        System.out.println("\n--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Hourly: " + roster.countHE()
                + " | Piece Worker: " + roster.countPWE()
                + " | Commission (Pure): " + roster.countCE()
                + " | Base Plus Commission: " + roster.countBPCE());

        // remove employee
        System.out.println("\n======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");

        Employee removed = roster.removeEmployee(201);

        if (removed != null) {
            System.out.println("Removing Employee ID 201... Successfully removed.");
        } else {
            System.out.println("Removing Employee ID 201... Not found.");
        }

        System.out.println("Updated Roster Size: " + roster.countEmployees());

        // display remaining employees
        System.out.println("\nCurrent Active Employees:");
        roster.displayAllEmployees();

        System.out.println("======================================================================");
    }
}