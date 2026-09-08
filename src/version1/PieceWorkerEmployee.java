package version1;

public class PieceWorkerEmployee {



    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        //initializes numeric values to 0 and string
    }

    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
    }

    public PieceWorkerEmployee(int empID, String empName, int
            totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }



    public double computeSalary(int  totalPiecesFinished, double ratePerPiece) {

        double over;
        double total;

        total = totalPiecesFinished * ratePerPiece;


            over = totalPiecesFinished / 100;
            over = over * 10 * ratePerPiece;

            double sum = total + over;

        return sum;
    }


    public displayPieceWorkerEmployee (int empID, int empName, int totalPicesFinsihed, float ratePerPiece) {

    }

}
