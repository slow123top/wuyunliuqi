package icat.sinomed.util;

/**
 * Created by liucong on  16-4-2-002.
 */
public class 公历日期 {
    public final int year;
    public final int month;
    public final int day;

    public 公历日期(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public 公历日期(String year, String month, String day) {
        this(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        公历日期 that = (公历日期) o;
        return year == that.year &&
                month == that.month &&
                day == that.day;
    }

    @Override
    public int hashCode() {
        return year << 9 | month << 5 | day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
