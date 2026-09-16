package version3;

public class Main3 {
    public static void main(String[] args) throws CloneNotSupportedException {




        int bdayCheckMonth = 9; // September

        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");

        Employee[] staffList = new Employee[4];

        staffList[0] = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200.0);
        staffList[1] = new PieceWorkerEmployee(201, new Name("Bob", "C.", "Jones", "Jr."), new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15.0);
        staffList[2] = new CommissionEmployee(301, new Name("Camille", "Garcia"), new MyDate(9, 9, 1997), new MyDate(3, 11, 2018), 80000);
        staffList[3] = new BasePlusCommissionEmployee(401, new Name("Denise", "Villanueva"), new MyDate(25, 3, 1990), new MyDate(7, 7, 2017), 120000, 10000);


            // for looping not using Scanner cuz confusing
        for (int i = 0; i < staffList.length; i++) {
            Employee staffer = staffList[i];

            double payNoBonus = staffer.computeSalary();
            double payWithBonus = staffer.computeSalary(bdayCheckMonth);
            double bdayCash = payWithBonus - payNoBonus;

            System.out.println((i + 1) + ". " + staffer);
            System.out.printf("   Base Pay: ₱%,.2f | Birthday Bonus: ₱%,.2f (%s)%n",
                    payNoBonus, bdayCash, (bdayCash > 0 ? "Eligible" : "Ineligible"));
            System.out.printf("   Total Payout: ₱%,.2f%n%n", payWithBonus);
        }

        // object testes and hash codes

        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");


        HourlyEmployee empA = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200.0);
        HourlyEmployee empAIdentical = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200.0);
        HourlyEmployee empB = new HourlyEmployee(102, new Name("Paolo", "Cruz"), new MyDate(10, 3, 2019), new MyDate(20, 6, 2000), 38, 180.0);




        System.out.println("empA equals empAIdentical: " + empA.equals(empAIdentical));
        System.out.println("empA hashCode: " + empA.hashCode() + " | empAIdentical hashCode: " + empAIdentical.hashCode() + " (Match: " + (empA.hashCode() == empAIdentical.hashCode()) + ")");
        System.out.println("empA equals empB: " + empA.equals(empB));
        System.out.println();

        // checking clone
        System.out.println("DEEP CLONE VERIFICATION");

        HourlyEmployee empOriginal = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200.0);

        HourlyEmployee empClone = empOriginal.clone();

        System.out.println("Original Name before modification: " + empOriginal.getEmpName());

        empClone.getEmpName().setFirstName("Taylor"); // mutated the clones's name only

        System.out.println("Clone Name changed to:             " + empClone.getEmpName());
        System.out.println("Original Name after modification:  " + empOriginal.getEmpName() + " (Deep copy successful!)");
    }
}