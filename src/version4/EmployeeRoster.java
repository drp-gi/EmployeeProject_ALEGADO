package version4;

public class EmployeeRoster {

    private Employee[] empList;
    private int max;
    private int count;

    // default constructor
    public EmployeeRoster() {
        max = 10;
        count = 0;
        empList = new Employee[max];
    }

    // constructor with custom size
    public EmployeeRoster(int max) {
        this.max = max;
        count = 0;
        empList = new Employee[max];
    }

    // getters and setters

    public Employee[] getEmpList() {
        return empList;
    }

    public void setEmpList(Employee[] empList) {
        this.empList = empList;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // add employee
    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) return false;

        empList[count] = emp;
        count++;

        return true;
    }

    // remove employee
    public Employee removeEmployee(int empID) {

        int index = -1;

        // find employee
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                index = i;
                break;
            }
        }

        if (index == -1) return null;

        Employee removed = empList[index];

        // move employees to the left
        for (int i = index; i < count - 1; i++) {
            empList[i] = empList[i + 1];
        }

        empList[count - 1] = null;
        count--;

        return removed;
    }

    // search employee
    public Employee searchEmployee(int empID) {

        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) return empList[i];
        }

        return null;
    }

    // count hourly employees
    public int countHE() {

        int c = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) c++;
        }

        return c;
    }

    // count piece worker employees
    public int countPWE() {

        int c = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) c++;
        }

        return c;
    }

    // count commission employees
    public int countCE() {

        int c = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof CommissionEmployee &&
                    !(empList[i] instanceof BasePlusCommissionEmployee)) {
                c++;
            }
        }

        return c;
    }

    // count base plus commission employees
    public int countBPCE() {

        int c = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) c++;
        }

        return c;
    }

    // display hourly employees
    public void displayHE() {

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) empList[i];
                he.displayHourlyEmployee();
            }
        }
    }

    // display piece worker employees
    public void displayPWE() {

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) empList[i];
                pwe.displayPieceWorkerEmployee();
            }
        }
    }

    // display commission employees
    public void displayCE() {

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof CommissionEmployee &&
                    !(empList[i] instanceof BasePlusCommissionEmployee)) {

                CommissionEmployee ce = (CommissionEmployee) empList[i];
                ce.displayCommissionEmployee();
            }
        }
    }

    // display base plus commission employees
    public void displayBPCE() {

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce =
                        (BasePlusCommissionEmployee) empList[i];

                bpce.displayBasePlusCommissionEmployee();
            }
        }
    }

    // display all employees
    public void displayAllEmployees() {

        for (int i = 0; i < count; i++) {

            Employee emp = empList[i];

            System.out.println((i + 1) + ". ID: " + emp.getEmpID()
                    + " | Name: " + emp.getEmpName()
                    + " | Type: " + emp.getClass().getSimpleName());
        }
    }

    // display payroll
    public void displayPayroll(int currentMonth) {

        for (int i = 0; i < count; i++) {

            Employee emp = empList[i];

            // check base plus commission first
            if (emp instanceof BasePlusCommissionEmployee) {

                BasePlusCommissionEmployee bpce =
                        (BasePlusCommissionEmployee) emp;

                double salary = bpce.computeSalary(currentMonth);

                System.out.println("[Base Plus Commission] ID: " + bpce.getEmpID()  +
                        " | Name: " + bpce.getEmpName()  +
                        " | Salary: ₱" + salary);

                // check commission employee
            } else if (emp instanceof CommissionEmployee) {

                CommissionEmployee ce = (CommissionEmployee) emp;
                double salary = ce.computeSalary(currentMonth);

                System.out.println("[Commission] ID: " + ce.getEmpID() +
                        " | Name: " + ce.getEmpName()
                        + " | Salary: ₱" + salary);

                // check hourly employee
            } else if (emp instanceof HourlyEmployee) {

                HourlyEmployee he = (HourlyEmployee) emp;
                double salary = he.computeSalary(currentMonth);

                System.out.println("[Hourly] ID: " + he.getEmpID()
                        + " | Name: " + he.getEmpName()
                        + " | Salary: ₱" + salary);

                // check piece worker employee
            } else if (emp instanceof PieceWorkerEmployee) {

                PieceWorkerEmployee pwe = (PieceWorkerEmployee) emp;
                double salary = pwe.computeSalary(currentMonth);

                System.out.println("[Piece Worker] ID: " + pwe.getEmpID()
                        + " | Name: " + pwe.getEmpName()
                        + " | Salary: ₱" + salary);
            }
        }
    }
}