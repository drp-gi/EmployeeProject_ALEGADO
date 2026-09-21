package version5;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {

    private List<Employee> empList;

    // default constructor
    public EmployeeRoster() {
        empList = new ArrayList<>();     //we go <>
    }

    // constructor
    public EmployeeRoster(int initialCapacity) {
        empList = new ArrayList<>(initialCapacity);
    }

    // getters and setters
    public List<Employee> getEmpList() { return empList; }
    public void setEmpList(List<Employee> empList) { this.empList = empList; }

    // add employee
    public boolean addEmployee(Employee emp) {
        if (emp == null) return false;
        empList.add(emp);
        return true;
    }

    // remove employee
    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                return empList.remove(i);
            }
        }
        return null;
    }

    // search employee
    public Employee searchEmployee(int empID) {
        for (Employee emp : empList) {
            if (emp.getEmpID() == empID) return emp;
        }
        return null;
    }

    // count employees
    public int countEmployees() { return empList.size(); }

    // display payroll
    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);

            System.out.printf("ID: %d | Name: %-25s | Payout: ₱%,.2f%n",
                    emp.getEmpID(), emp.getEmpName(), salary);
        }
    }

    // count hourly employees
    public int countHE() {
        int c = 0;

        for (Employee emp : empList) {
            if (emp instanceof HourlyEmployee) c++;
        }

        return c;
    }

    // count piece worker employees
    public int countPWE() {
        int c = 0;

        for (Employee emp : empList) {
            if (emp instanceof PieceWorkerEmployee) c++;
        }

        return c;
    }

    // count commission employees
    public int countCE() {
        int c = 0;

        for (Employee emp : empList) {
            if (emp instanceof CommissionEmployee &&
                    !(emp instanceof BasePlusCommissionEmployee)) {
                c++;
            }
        }

        return c;
    }

    // count base plus commission employees
    public int countBPCE() {
        int c = 0;

        for (Employee emp : empList) {
            if (emp instanceof BasePlusCommissionEmployee) c++;
        }

        return c;
    }

    // display all employees
    public void displayAllEmployees() {
        int i = 1;

        for (Employee emp : empList) {
            System.out.println(i + ". " + emp);
            i++;
        }
    }
}