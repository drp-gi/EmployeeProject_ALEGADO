import version1.HourlyEmployee;
import version1.PieceWorkerEmployee;
import version1.CommissionEmployee;
import version1.BasePlusCommissionEmployee;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Hourly Employee Test ---\n");

        // I am not using any scanners for now - maybe next time:))
        HourlyEmployee a = new HourlyEmployee();
        a.setEmpID(101);
        a.setEmpName("Alice Smith");
        a.setTotalHoursWorked(45);
        a.setRatePerHour(200.0);

        HourlyEmployee a2 = new HourlyEmployee(102, "Ben Cruz", 38, 180.0);

        System.out.println("[displayHourlyEmployee()]\n");
        a.displayHourlyEmployee();
        a2.displayHourlyEmployee();

        System.out.println("\n[toString()]\n");
        //to string here
        System.out.println(a);
        System.out.println(a2);


        //case 2
        System.out.println("\n--- Piece Worker Employee Test ---\n");

        PieceWorkerEmployee b = new PieceWorkerEmployee();
        b.setEmpID(201);
        b.setEmpName("Bobby Jones");
        b.setTotalPiecesFinished(250);
        b.setRatePerPiece(15.0);

        PieceWorkerEmployee b2 = new PieceWorkerEmployee(202, "Carla Reyes", 180, 12.0);

        System.out.println("[displayPieceWorkerEmployee()]\n");
        b.displayPieceWorkerEmployee();
        b2.displayPieceWorkerEmployee();

        System.out.println("\n[toString()]\n");
        System.out.println(b);
        System.out.println(b2);


        //case 3
        System.out.println("\n--- Commission Employee Test ---\n");

        CommissionEmployee c = new CommissionEmployee();
        c.setEmpID(301);
        c.setEmpName("Meow Rejas");
        c.setTotalSale(80000);

        CommissionEmployee c2 = new CommissionEmployee(302, "Erwin Tan", 600000);

        System.out.println("[displayCommissionEmployee()]\n");
        c.displayCommissionEmployee();
        c2.displayCommissionEmployee();

        System.out.println("\n[toString()]\n");
        System.out.println(c);
        System.out.println(c2);


        //case 4
        System.out.println("\n--- Base Plus Commission Employee Test ---\n");

        BasePlusCommissionEmployee d = new BasePlusCommissionEmployee();
        d.setEmpID(401);
        d.setEmpName("Sakadung Padding");
        d.setTotalSale(120000);
        d.setBaseSalary(10000);

        BasePlusCommissionEmployee d2 = new BasePlusCommissionEmployee(402, "George Diaz", 45000, 8000);

        System.out.println("[displayBasePlusCommissionEmployee()]\n");
        d.displayBasePlusCommissionEmployee();
        d2.displayBasePlusCommissionEmployee();

        System.out.println("\n[toString()]\n");
        System.out.println(d);
        System.out.println(d2);
    }
}