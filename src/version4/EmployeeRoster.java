package version4;

public class EmployeeRoster {

    private Employee[] empList;
    private int max;
    private int count;

    public void EmployeeRoster() {
        this.max = 10;
        this.count = 0;
        this.empList= new Employee[max];
    }
    public EmployeeRoster(int max) {
        this.max = max;
        this.empList = new Employee[this.max];
        this.count = 0;
    }


    // getter setters



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

    public Employee removeEmployee (int empID) {
        // search for the emnpId
        for (int i = 0 ; i < max; i++) {
            if (empID == ) {
                int mindex = i;

                    for (int j = mindex; j  < count; j )  //tbc
            }

        }

    }



    public Employee searchEmployee (int empID) {

        for (int i = 0; i < max; i++) {
            if (empID ==) {
                int mindex = i;
                Employee[] store = new Employee[i];
                   // syntax please
                for (int j = mindex; j < count-1; j++) {//tbc  -----------------
                    Employee[j]  = Employee [j+1];
                    Employee
                    Employee[count] = null;
                    count--;

                }
            return store;
            }
        }

    }







    public boolean addEmployee (Employee yee) {
        if (count >= max || yee == null) {
            return false;
        }
        if (count < max) {
            empList[count] = yee;
            count++;
            return true;
        }
    }

    public










    public boolean addEmployee(Employee emp) {
        if (count >= max || emp == null) {
            return false;
        }
        empList[count] = emp;
        count++;
        return true;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {

            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }
        return null;
    }







}
