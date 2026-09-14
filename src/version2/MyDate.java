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
        return month;
    }

    public int getDay() {
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