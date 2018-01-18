package icat.sinomed.util;

/**
 * Created by liucong on  16-4-2-002.
 */
public class 农历日期 {

    public static final 干支 干支1900 = 干支.庚子;

    static final char[]   MONTH_NAMES = new char[]{' ', '正', '二', '三', '四', '五', '六', '七', '八', '九', '十', '冬', '腊'};
    static final String[] DAY_NAMES   = new String[]{"",
            "初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十",
            "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十",
            "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十"};
    //    public final int 干支年;
    public final 干支 干支年;
    public final int                          year;
    public final int                          month;
    public final int                          day;

    public 农历日期(String 干支年, String year, String month, String day) {
        this(干支年, Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    public 农历日期(String 干支年, int year, int month, int day) {
        this.干支年 = 干支.valueOf(干支年);
        if (干支年 == null) {
            throw new RuntimeException("天干地支年格式错误, 参数为:" + 干支年);
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public 农历日期(int year, int month, int day) {
        int targetIntValue = 干支1900.get序号() + ((year - 1900) % 60);
        targetIntValue = targetIntValue > 60 ? targetIntValue - 60 : targetIntValue < 1 ? targetIntValue + 60 : targetIntValue;
        this.干支年 = 干支.fromIntValue(targetIntValue);
        this.year = year;
        this.month = month;
        this.day = day;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        农历日期 that = (农历日期) o;
        return year == that.year &&
                month == that.month &&
                day == that.day &&
                干支年 == that.干支年;
    }

    @Override
    public int hashCode() {
        return year << 15 | 干支年.get序号() << 9 | month << 5 | day;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(干支年.toString());
        sb.append("(");
        sb.append(year);
        sb.append(")");

        if (month < 0) {
            sb.append("闰");
            sb.append(MONTH_NAMES[-month]);
        } else {
            sb.append(MONTH_NAMES[month]);
        }
        sb.append("月");
        sb.append(DAY_NAMES[day]);
        return sb.toString();
    }
}
