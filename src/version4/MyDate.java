package version4;

public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public MyDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;

        } else {
            System.out.println("Invalid day:)\n");
            this.day = 1;
        }


    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            System.out.println("Invalid month, defaulting to 1.");
            this.month = 1;
        }
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        } else {
            System.out.println("Invalid year, defaulting to 2000.");
            this.year = 2000;
        }
    }

    public boolean isSameMonthAs(int currentMonth) {
        return this.month == currentMonth;
    }

    public void displayDate() {
        System.out.println(this.toString());
    }




    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof MyDate)) return false;    // if not of name enddd it
        MyDate other = (MyDate) obj;
        return this.day == other.day
                && this.month == other.month
                && this.year == other.year;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(day, month, year);

    }

    @Override
    public MyDate clone() throws CloneNotSupportedException {
        return (MyDate) super.clone();
    }

    @Override
    public String toString() {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return String.format("%02d %s %d", day, months[month - 1], year);
    }

}