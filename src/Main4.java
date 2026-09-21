package version4;

public class Main4 {

    public static void main(String[] args) {

        // Create a roster that can hold 6 employees
        EmployeeRoster roster = new EmployeeRoster(6);

        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");

        // Add Hourly Employee
        HourlyEmployee he1 = new HourlyEmployee(
                101,
                new Name("Alice", "M.", "Smith"),
                new MyDate(14, 9, 1995),
                new MyDate(1, 6, 2020),
                45f,
                300.0
        );

        boolean added = roster.addEmployee(he1);
        System.out.println("Added: " + he1.getEmpName() + " (Hourly) -> " + added);


        // Add Piece Worker Employee
        PieceWorkerEmployee pwe1 = new PieceWorkerEmployee(
                201,
                new Name("Bob", "C.", "Jones", "Jr."),
                new MyDate(3, 4, 1990),
                new MyDate(15, 1, 2021),
                135,
                30.0
        );

        added = roster.addEmployee(pwe1);
        System.out.println("Added: " + pwe1.getEmpName() + " (Piece Worker) -> " + added);


        // Add Commission Employee
        CommissionEmployee ce1 = new CommissionEmployee(
                301,
                new Name("Maria", "L.", "Reyes"),
                new MyDate(20, 9, 1988),
                new MyDate(10, 3, 2019),
                100000.0
        );

        added = roster.addEmployee(ce1);
        System.out.println("Added: " + ce1.getEmpName() + " (Commission) -> " + added);


        // Add Base Plus Commission Employee
        BasePlusCommissionEmployee bpce1 = new BasePlusCommissionEmployee(
                401,
                new Name("Kevin", "S.", "Tan"),
                new MyDate(11, 2, 1992),
                new MyDate(5, 7, 2018),
                80000.0,
                20000.0
        );

        added = roster.addEmployee(bpce1);
        System.out.println("Added: " + bpce1.getEmpName()
                + " (Base Plus Commission) -> " + added);


        // Add another Hourly Employee
        HourlyEmployee he2 = new HourlyEmployee(102,
                new Name("David", "A.", "White"),
                new MyDate(30, 11, 1985),
                new MyDate(20, 8, 2022),
                40f,
                200.0
        );

        added = roster.addEmployee(he2);
        System.out.println("Added: " + he2.getEmpName() + " (Hourly) -> " + added);


        // Add one more employee to fill the roster
        PieceWorkerEmployee pwe2 = new PieceWorkerEmployee(
                202,
                new Name("Extra", "Worker"),
                new MyDate(1, 1, 1999),
                new MyDate(1, 1, 2023),
                50,
                25.0
        );

        added = roster.addEmployee(pwe2);
        System.out.println("Added: " + pwe2.getEmpName()
                + " (Piece Worker, fills capacity) -> " + added);


        // Try to add another employee after the roster is full
        Employee overflow = new HourlyEmployee(
                999,
                new Name("Overflow", "Guy"),
                new MyDate(1, 1, 2000),
                new MyDate(1, 1, 2024),
                10f,
                100.0
        );

        added = roster.addEmployee(overflow);

        System.out.println("Attempt to add beyond capacity -> " + added);

        System.out.println("Roster Count: " + roster.getCount());
        System.out.println("Maximum Capacity: " + roster.getMax());


        // Show employee counts
        System.out.println("\n--- ROSTER COMPOSITION COUNTS ---");

        System.out.println("Total Employees: "  + roster.getCount() + " / " + roster.getMax());

        System.out.println("Hourly Employees: " + roster.countHE());

        System.out.println("Piece Worker Employees: " + roster.countPWE());

        System.out.println("Commission Employees (Pure): " + roster.countCE());

        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());


        // display hourly employees
        System.out.println("\n--- HOURLY EMPLOYEES ---");
        roster.displayHE();


        // display base plus commison employees
        System.out.println("\n--- BASE PLUS COMMISSION EMPLOYEES ---");
        roster.displayBPCE();



        System.out.println("\n======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        roster.displayPayroll(9);


        //removing an employee
        System.out.println("\n======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");

        Employee removed = roster.removeEmployee(201);

        if (removed != null) {
            System.out.println("Removing Employee ID 201...");
            System.out.println("Employee Name: " + removed.getEmpName());
            System.out.println("Successfully removed.");
        } else {
            System.out.println("Employee ID 201 was not found.");
        }

        System.out.println("Current Employee Count: " + roster.getCount());


        // Display remaining employees
        System.out.println("\nRemaining Employees in Roster:");

        roster.displayAllEmployees();

        System.out.println("======================================================================");
    }
}