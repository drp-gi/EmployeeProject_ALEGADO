package version6;

public final class MyDate implements Cloneable {

    private int day;
    private int month;
    private int year;

    // constructor
    public MyDate(int day, int month, int year) {
        validate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // validate date
    private static void validate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid calendar date");
        }

        if (year <= 1900) {
            throw new IllegalArgumentException("Invalid calendar date");
        }

        int maxDay = daysInMonth(month, year);

        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException("Invalid calendar date");
        }
    }

    // get days in month
    private static int daysInMonth(int month, int year) {
        int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) return 29;

        return daysPerMonth[month - 1];
    }

    // check leap year
    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    // getters and setters
    public int getDay() { return day; }

    public void setDay(int day) {
        validate(day, month, year);
        this.day = day;
    }

    public int getMonth() { return month; }

    public void setMonth(int month) {
        validate(day, month, year);
        this.month = month;
    }

    public int getYear() { return year; }

    public void setYear(int year) {
        validate(day, month, year);
        this.year = year;
    }

    // check month
    public boolean isSameMonthAs(int currentMonth) {
        return month == currentMonth;
    }

    // display date
    public void displayDate() {
        System.out.println(this);
    }

    // compare dates
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyDate)) return false;

        MyDate other = (MyDate) obj;

        return day == other.day
                && month == other.month
                && year == other.year;
    }

    // create hash code
    @Override public int hashCode() { return java.util.Objects.hash(day, month, year); }

    // clone date
    @Override public MyDate clone() { return new MyDate(day, month, year); }

    // convert to string
    @Override
    public String toString() {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        return String.format("%02d %s %d", day, months[month - 1], year);
    }
}