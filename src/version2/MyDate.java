package version2;

public class MyDate {
    private final int day;
    private final int month;
    private final int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getMonth() {
        if (this.month > 12 || this.month < 1) {
            System.out.println("Enter valid month number\n");
        }
        return month;
    }

    public int getDay() {
        if (this.month > 31 || this.month < 1) {
            System.out.println("Enter valid day number\n");
        }
        return day;
    }

    public int getYear() {
        return year;
    }

    public boolean isSameMonthAs(int currentMonth) {
        return this.month == currentMonth;
    }

    @Override
    public String toString() {
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun",
                "Jul","Aug","Sep","Oct","Nov","Dec"};
        return day + " " + months[month - 1] + " " + year;
    }
}