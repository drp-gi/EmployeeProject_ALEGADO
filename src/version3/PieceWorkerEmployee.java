package version3;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);

        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        } else {
            System.out.println("Invalid pieces, defaulting to 0.");
            this.totalPiecesFinished = 0;
        }
    }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        } else {
            System.out.println("Invalid rate");
            this.ratePerPiece = 0;
        }
    }


    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;

        double bonusPay = (totalPiecesFinished / 100) * (10 * ratePerPiece);
        return basePay + bonusPay + super.computeSalary(currentMonth);
    }


    public void displayPieceWorkerEmployee() {
        super.displayEmployee();
        System.out.printf("Pieces Finished: %d | Rate/Piece: ₱%.2f%n", totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format(
                "PieceWorkerEmployee [%s, Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%,.2f]", super.toString(), totalPiecesFinished, ratePerPiece, computeSalary());
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PieceWorkerEmployee)) return false;
        if (!super.equals(obj)) return false;
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return this.totalPiecesFinished == other.totalPiecesFinished
                && this.ratePerPiece == other.ratePerPiece;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() throws CloneNotSupportedException {
        return (PieceWorkerEmployee) super.clone();
    }
}