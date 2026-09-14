import version2.HourlyEmployee;
import version2.PieceWorkerEmployee;
import version2.CommissionEmployee;
import version2.BasePlusCommissionEmployee;
import version2.Name;
import version2.MyDate;

public class Main2 {
    public static void main(String[] args) {

        int currentMonth = 9; // September rn, this is the month we're testing the bday bonus against

        System.out.println("--- Hourly Employee Test ---\n");

        HourlyEmployee a = new HourlyEmployee();
        a.setEmpID(101);
        a.setEmpName(new Name("Alyssa", "Reyes"));
        a.setDateHired(new MyDate(1, 6, 2020));
        a.setBirthDate(new MyDate(15, 9, 1998)); // sept bday, bonus should hit
        a.setTotalHoursWorked(45);
        a.setRatePerHour(200.0);
        System.out.println(a.getEmpName() + " getter setter check, we outchea\n");

        HourlyEmployee a2 = new HourlyEmployee(102, new Name("Paolo", "Cruz"),
                new MyDate(10, 3, 2019), new MyDate(20, 6, 2000), 38, 180.0);
        // not a sept bday, no bonus for this one

        System.out.println("[displayHourlyEmployee()]\n");
        a.displayHourlyEmployee();
        a2.displayHourlyEmployee();

        System.out.println("\n[toString()]\n");
        System.out.println(a);
        System.out.println(a2);


        System.out.println("\n--- Piece Worker Employee Test ---\n");

        PieceWorkerEmployee b = new PieceWorkerEmployee();
        b.setEmpID(201);
        b.setEmpName(new Name("Bianca", "Santos"));
        b.setDateHired(new MyDate(5, 1, 2021));
        b.setBirthDate(new MyDate(2, 9, 1995)); // sept bday
        b.setTotalPiecesFinished(250);
        b.setRatePerPiece(15.0);

        PieceWorkerEmployee b2 = new PieceWorkerEmployee(202, new Name("Miguel", "Lopez"),
                new MyDate(15, 8, 2022), new MyDate(30, 4, 1999), 180, 12.0);
        // fixed the rate=0 bug from v1, ratePerPiece actually works now

        System.out.println("[displayPieceWorkerEmployee()]\n");
        b.displayPieceWorkerEmployee();
        b2.displayPieceWorkerEmployee();

        System.out.println("\n[toString()]\n");
        System.out.println(b);
        System.out.println(b2);


        System.out.println("\n--- Commission Employee Test ---\n");

        CommissionEmployee c = new CommissionEmployee();
        c.setEmpID(301);
        c.setEmpName(new Name("Camille", "Garcia"));
        c.setDateHired(new MyDate(3, 11, 2018));
        c.setBirthDate(new MyDate(9, 9, 1997)); // sept bday
        c.setTotalSale(80000);

        CommissionEmployee c2 = new CommissionEmployee(302, new Name("Josh", "Mendoza"),
                new MyDate(20, 2, 2020), new MyDate(11, 12, 1993), 600000);
        // tier 4 sales, 20% commission rate

        System.out.println("[displayCommissionEmployee()]\n");
        c.displayCommissionEmployee();
        c2.displayCommissionEmployee();

        System.out.println("\n[toString()]\n");
        System.out.println(c);
        System.out.println(c2);


        System.out.println("\n--- Base Plus Commission Employee Test ---\n");

        BasePlusCommissionEmployee d = new BasePlusCommissionEmployee();
        d.setEmpID(401);
        d.setEmpName(new Name("Denise", "Villanueva"));
        d.setDateHired(new MyDate(7, 7, 2017));
        d.setBirthDate(new MyDate(25, 9, 1990)); // sept bday
        d.setTotalSale(120000);
        d.setBaseSalary(10000);

        BasePlusCommissionEmployee d2 = new BasePlusCommissionEmployee(402, new Name("Enzo", "Ramos"),
                new MyDate(1, 10, 2021), new MyDate(14, 5, 1996), 45090, 4500);
        // no bday bonus for this one

        System.out.println("[displayBasePlusCommissionEmployee()]\n");
        d.displayBasePlusCommissionEmployee();
        d2.displayBasePlusCommissionEmployee();

        System.out.println("\n[toString()]\n");
        System.out.println(d);
        System.out.println(d2 + "\n");
    }
}