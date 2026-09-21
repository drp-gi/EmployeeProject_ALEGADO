package version5;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    // default constructor
    public PieceWorkerEmployee() {
        super();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    // constructor
    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    // getters and setters
    public int getTotalPiecesFinished() { return totalPiecesFinished; }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) this.totalPiecesFinished = totalPiecesFinished;
        else {
            System.out.println("Invalid pieces, defaulting to 0.");
            this.totalPiecesFinished = 0;
        }
    }

    public double getRatePerPiece() { return ratePerPiece; }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) this.ratePerPiece = ratePerPiece;
        else {
            System.out.println("Invalid rate");
            this.ratePerPiece = 0;
        }
    }

    // calculate salary
    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        double productionBonus = (totalPiecesFinished / 100) * (10 * ratePerPiece);
        double birthdayBonus = 0;

        if (getBirthDate().isSameMonthAs(currentMonth)) {
            birthdayBonus = BIRTHDAY_BONUS;
        }

        return basePay + productionBonus + birthdayBonus;
    }

    // display employee
    public void displayPieceWorkerEmployee() {
        super.displayEmployee();
        System.out.printf("Pieces Finished: %d | Rate/Piece: ₱%.2f%n", totalPiecesFinished, ratePerPiece);
    }

    // convert to string
    @Override public String toString() { return "PieceWorkerEmployee [ID: " + getEmpID() + ", Name: " + getEmpName() + ", Total Salary: ₱" + computeSalary() + "]"; }

    // compare employees
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PieceWorkerEmployee)) return false;
        if (!super.equals(obj)) return false;

        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;

        return totalPiecesFinished == other.totalPiecesFinished
                && ratePerPiece == other.ratePerPiece;
    }

    // create hash code
    @Override public int hashCode() { return java.util.Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece); }

    // clone employee
    @Override public PieceWorkerEmployee clone() throws CloneNotSupportedException { return (PieceWorkerEmployee) super.clone(); }
}