package icat.sinomed.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by liucong on  16-4-3-003.
 */
public class 时相 {

    public static final String 标志_阴 = "▼";
    public static final String 标志_阳 = "▲";

    气 司天;
    气 客气;
    气 中运;
    气 主气;
    气 在泉;

    String 年天干阴阳标志;

    公历日期 当前公历日期;
    农历日期 当前农历日期;

    protected 时相(气 司天, 气 客气, 气 中运, 气 主气, 气 在泉, String 年天干阴阳标志) {
        this.司天 = 司天;
        this.客气 = 客气;
        this.中运 = 中运;
        this.主气 = 主气;
        this.在泉 = 在泉;
        this.年天干阴阳标志 = 年天干阴阳标志;
    }





    public 气 get司天() {
        return 司天;
    }

    public 气 get客气() {
        return 客气;
    }

    public 气 get中运() {
        return 中运;
    }

    public 气 get主气() {
        return 主气;
    }

    public 气 get在泉() {
        return 在泉;
    }

    public String get年天干阴阳标志() {
        return 年天干阴阳标志;
    }

    public 公历日期 get当前公历日期() {
        return 当前公历日期;
    }

    public 农历日期 get当前农历日期() {
        return 当前农历日期;
    }

    protected 时相 set当前公历日期(公历日期 当前公历日期) {
        this.当前公历日期 = 当前公历日期;
        return this;
    }

    protected 时相 set当前农历日期(农历日期 当前农历日期) {
        this.当前农历日期 = 当前农历日期;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        时相 时相 = (时相) o;
        return 司天 == 时相.司天 &&
                客气 == 时相.客气 &&
                中运 == 时相.中运 &&
                主气 == 时相.主气 &&
                在泉 == 时相.在泉;
    }

    @Override
    public int hashCode() {
        return Objects.hash(司天, 客气, 中运, 主气, 在泉);
    }

    @Override
    public String toString() {
        return "时相{" +
                "司天=" + 司天 +
                ", 客气=" + 客气 +
                ", 中运=" + 中运 +
                ", 主气=" + 主气 +
                ", 在泉=" + 在泉 +
                '}';
    }

    /**
     * Created by liucong on  16-4-6-006.
     */
    @Service
    public static class 时相服务 {
        static final HashMap<节气, 气> 节气主气映射表 = new HashMap<>();
        static final HashMap<天干, 气>                           天干中运映射表 = new HashMap<>();
        static final HashMap<地支, 气>                           地支司天映射表 = new HashMap<>();

        static final 气[] 客气表 = new 气[]{气.厥阴风木, 气.少阴君火, 气.太阴湿土, 气.少阳相火, 气.阳明燥金, 气.太阳寒水};

        static {
            节气主气映射表.put(节气.大寒, 气.厥阴风木);
            节气主气映射表.put(节气.立春, 气.厥阴风木);
            节气主气映射表.put(节气.雨水, 气.厥阴风木);
            节气主气映射表.put(节气.惊蛰, 气.厥阴风木);
            节气主气映射表.put(节气.春分, 气.少阴君火);
            节气主气映射表.put(节气.清明, 气.少阴君火);
            节气主气映射表.put(节气.谷雨, 气.少阴君火);
            节气主气映射表.put(节气.立夏, 气.少阴君火);
            节气主气映射表.put(节气.小满, 气.少阳相火);
            节气主气映射表.put(节气.芒种, 气.少阳相火);
            节气主气映射表.put(节气.夏至, 气.少阳相火);
            节气主气映射表.put(节气.小暑, 气.少阳相火);
            节气主气映射表.put(节气.大暑, 气.太阴湿土);
            节气主气映射表.put(节气.立秋, 气.太阴湿土);
            节气主气映射表.put(节气.处暑, 气.太阴湿土);
            节气主气映射表.put(节气.白露, 气.太阴湿土);
            节气主气映射表.put(节气.秋分, 气.阳明燥金);
            节气主气映射表.put(节气.寒露, 气.阳明燥金);
            节气主气映射表.put(节气.霜降, 气.阳明燥金);
            节气主气映射表.put(节气.立冬, 气.阳明燥金);
            节气主气映射表.put(节气.小雪, 气.太阳寒水);
            节气主气映射表.put(节气.大雪, 气.太阳寒水);
            节气主气映射表.put(节气.冬至, 气.太阳寒水);
            节气主气映射表.put(节气.小寒, 气.太阳寒水);

            天干中运映射表.put(天干.甲, 气.太阴湿土);
            天干中运映射表.put(天干.乙, 气.阳明燥金);
            天干中运映射表.put(天干.丙, 气.太阳寒水);
            天干中运映射表.put(天干.丁, 气.厥阴风木);
            天干中运映射表.put(天干.戊, 气.少阴君火);
            天干中运映射表.put(天干.己, 气.太阴湿土);
            天干中运映射表.put(天干.庚, 气.阳明燥金);
            天干中运映射表.put(天干.辛, 气.太阳寒水);
            天干中运映射表.put(天干.壬, 气.厥阴风木);
            天干中运映射表.put(天干.癸, 气.少阴君火);

            地支司天映射表.put(地支.子, 气.少阴君火);
            地支司天映射表.put(地支.丑, 气.太阴湿土);
            地支司天映射表.put(地支.寅, 气.少阳相火);
            地支司天映射表.put(地支.卯, 气.阳明燥金);
            地支司天映射表.put(地支.辰, 气.太阳寒水);
            地支司天映射表.put(地支.巳, 气.厥阴风木);
            地支司天映射表.put(地支.午, 气.少阴君火);
            地支司天映射表.put(地支.未, 气.太阴湿土);
            地支司天映射表.put(地支.申, 气.少阳相火);
            地支司天映射表.put(地支.酉, 气.阳明燥金);
            地支司天映射表.put(地支.戌, 气.太阳寒水);
            地支司天映射表.put(地支.亥, 气.厥阴风木);
        }


        @Autowired
        节气工具 当前节气工具;

        @Autowired
        日历转换工具 当前日历转换工具;

        private static 气 由地支算在泉(地支 当前地支) {
            int 目标地支数值 = 当前地支.get序号() + 3;
            if (目标地支数值 > 12) {
                目标地支数值 -= 12;
            }
            return 地支司天映射表.get(地支.fromIntValue(目标地支数值));
        }

        public 时相 fromLocalDateTime(LocalDateTime time) {
            final 节气 当前时相的节气 = 当前节气工具.getSolarTerm(time);
            final 气  主气      = 节气主气映射表.get(当前时相的节气);

            final int   year   = time.getYear();
            final Month month  = time.getMonth();
            final int   day    = time.getDayOfMonth();
            final 公历日期  当前公历日期 = new 公历日期(year, month.getValue(), day);
            final 农历日期  当前农历日期 = 当前日历转换工具.getChineseDate(当前公历日期);

            final 气 中运 = 天干中运映射表.get(当前农历日期.干支年.干);
            final 气 司天 = 地支司天映射表.get(当前农历日期.干支年.支);
            final 气 在泉 = 由地支算在泉(当前农历日期.干支年.支);

            String 年天干阴阳标志 = 当前农历日期.干支年.干.get序号() % 2 == 0 ? 标志_阴 : 标志_阳;

            final 气 客气   = 由主气司天计算客气(主气, 司天);
            final 时相                          当前时相 = new 时相(司天, 客气, 中运, 主气, 在泉, 年天干阴阳标志);

            当前时相.set当前公历日期(当前公历日期);
            当前时相.set当前农历日期(当前农历日期);
            return 当前时相;
        }

        private static 气 由主气司天计算客气(气 主气, 气 司天) {
            final int 主气步 = 主气.步;

            int 客气索引 = -1;
            for (int i = 0; i < 客气表.length; i++) {
                if (客气表[i] == 司天) {
                    // 这是今年客气的第三步
                    客气索引 = (i + (主气步 - 3)) % 6;
                    if (客气索引 < 0) {
                        客气索引 += 6;
                    }
                    break;
                }
            }
            if (客气索引 < 0) {
                throw new RuntimeException("计算客气失败");
            }
            return 客气表[客气索引];
        }


    }
}
