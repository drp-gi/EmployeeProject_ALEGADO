package version2;

public class PieceWorkerEmployee {

    private int empID;
    private Name empName;
    private MyDate dateHired;
    private MyDate birthDate;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public static final double BIRTHDAY_BONUS = 5000;

    public PieceWorkerEmployee() {
        this.empName = null;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate dateHired, MyDate birthDate) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate dateHired, MyDate birthDate,
                               int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public Name getEmpName() { return empName; }
    public void setEmpName(Name empName) { this.empName = empName; }

    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }

    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) { this.totalPiecesFinished = totalPiecesFinished; }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) { this.ratePerPiece = ratePerPiece; }

    public double computeSalary(int currentMonth) {
        double total = totalPiecesFinished * ratePerPiece;

        double over = totalPiecesFinished / 100;
        over = over * 10 * ratePerPiece;

        double sum = total + over;

        if (birthDate.isSameMonthAs(currentMonth)) {
            sum += BIRTHDAY_BONUS;
        }

        return sum;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | Pieces Finished: %d | Rate: %.2f\n",
                empID, empName, totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("Overall Details\nID: %d Name: %s Pieces: %d Rate: ₱%.2f Total Salary: %.2f]",
                empID, empName, totalPiecesFinished, ratePerPiece, computeSalary(9));
    }
}