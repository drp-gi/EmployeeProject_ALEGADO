package version6;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    // constructor
    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    // getters and setters
    public int getTotalPiecesFinished() { return totalPiecesFinished; }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0) throw new IllegalArgumentException("Total pieces finished cannot be negative.");
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() { return ratePerPiece; }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0) throw new IllegalArgumentException("Rate per piece cannot be negative.");
        this.ratePerPiece = ratePerPiece;
    }

    // calculate salary
    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        double productionBonus = (totalPiecesFinished / 100) * (10 * ratePerPiece);
        return basePay + productionBonus + getBirthdayBonus(currentMonth);
    }

    // calculate salary without month
    @Override public double computeSalary() { return computeSalary(-1); }

    // display employee
    @Override
    public void displayEmployee() {
        System.out.printf("ID: %d | Name: %s | Pieces: %d | Rate: ₱%.2f/piece%n",
                getEmpID(), getEmpName(), totalPiecesFinished, ratePerPiece);
    }

    // convert to string
    @Override public String toString() { return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Total Salary: ₱%.2f]", getEmpID(), getEmpName(), computeSalary()); }

    // compare employees
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PieceWorkerEmployee)) return false;
        if (!super.equals(obj)) return false;

        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished && ratePerPiece == other.ratePerPiece;
    }

    // create hash code
    @Override public int hashCode() { return java.util.Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece); }

    // clone employee
    @Override public PieceWorkerEmployee clone() { return (PieceWorkerEmployee) super.clone(); }
}