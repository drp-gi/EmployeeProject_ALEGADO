package version6;

public class Main6 {

    public static void main(String[] args) {

        // test encapsulation and defensive copying
        System.out.println("======================================================================");
        System.out.println("1. TESTING ENCAPSULATION & DEFENSIVE COPYING");
        System.out.println("======================================================================");

        HourlyEmployee guard = new HourlyEmployee(
                901, new Name("Test", "Guard"), new MyDate(15, 12, 1995), new MyDate(1, 1, 2020),
                40f, 250.0);

        System.out.println("Original Birth Month: " + guard.getBirthDate().getMonth() + " (Dec)");
        System.out.println("Attempting to change birth month to 9...");

        guard.getBirthDate().setMonth(9);

        System.out.println("Employee's Actual Birth Date: " + guard.getBirthDate());

        if (guard.getBirthDate().getMonth() == 12) {
            System.out.println("Result: SUCCESS (Internal state protected)");
        } else {
            System.out.println("Result: FAILURE (Internal state was changed)");
        }

        // test exception handling and validation
        System.out.println("\n======================================================================");
        System.out.println("2. TESTING EXCEPTION HANDLING & INPUT VALIDATION");
        System.out.println("======================================================================");

        System.out.println("Attempting to create employee with rate: -150.00...");

        try {
            HourlyEmployee bad = new HourlyEmployee(
                    902, new Name("Bad", "Rate"),
                    new MyDate(1, 1, 1990), new MyDate(1, 1, 2020),
                    40f, -150.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        System.out.println("\nAttempting to create invalid date: 31 Feb 2026...");

        try {
            MyDate badDate = new MyDate(31, 2, 2026);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        // test polymorphic payroll
        System.out.println("\n======================================================================");
        System.out.println("3. POLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster();

        roster.addEmployee(new HourlyEmployee(
                101, new Name("Alice", "M.", "Smith"),
                new MyDate(14, 9, 1995), new MyDate(1, 6, 2020),
                45f, 300.0));

        roster.addEmployee(new PieceWorkerEmployee(
                201, new Name("Bob", "C.", "Jones", "Jr."),
                new MyDate(3, 4, 1990), new MyDate(15, 1, 2021),
                135, 30.0));

        roster.addEmployee(new CommissionEmployee(
                301, new Name("Maria", "L.", "Reyes"),
                new MyDate(20, 9, 1988), new MyDate(10, 3, 2019),
                100000.0));

        roster.addEmployee(new BasePlusCommissionEmployee(
                401, new Name("Kevin", "S.", "Tan"),
                new MyDate(11, 2, 1992), new MyDate(5, 7, 2018),
                80000.0, 20000.0));

        roster.displayPayroll(9);

        System.out.println("======================================================================");
    }
}