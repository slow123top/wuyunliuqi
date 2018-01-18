package icat.sinomed.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

/**
 * Created by liucong on  16-4-2-002.
 */
@Component
public class 日历转换工具 {

    private int GREGORIAN_YEAR_BEGIN;
    private int CHINESE_GREGORIAN_YEAR_BEGIN;

    private static final 干支 干支1900 = 干支.庚子;

    // 年 月 日
    农历日期[][][]   GREGORIAN_DATE_TO_农历日期_TABLE;
    // 年，月，日, 平月0/闰月1
    公历日期[][][][] CHINESE_DATE_TO_公历日期_TABLE;

    @Autowired
    ApplicationContext context;

    @Value("${app.sinomed.GregorianDateChineseDateTablePath}")
    String gregorianDateChineseDateTablePath;

    @PostConstruct
    private void postConstruct() {
        final Resource resource = context.getResource(gregorianDateChineseDateTablePath);
        try (final InputStream calendarTableInputStream = resource.getInputStream();
             final BufferedReader calendarTableReader = new BufferedReader(new InputStreamReader(calendarTableInputStream, Charset.forName("UTF-8")))) {
            final List<Pair<公历日期, 农历日期>> gregorianDateChineseDatePairs = calendarTableReader.lines().skip(1)
                    .map(line -> line.split(","))
                    .filter(arr -> arr.length == 6)
                    .map(日历转换工具::csvArrayToGregorianDateChineseDatePair)
                    .collect(Collectors.toList());

            final Pair<公历日期, 农历日期> p = gregorianDateChineseDatePairs.get(0);
            GREGORIAN_YEAR_BEGIN = p.getFirst().year;
            CHINESE_GREGORIAN_YEAR_BEGIN = p.getSecond().year;

            final Pair<公历日期, 农历日期> lastpair = gregorianDateChineseDatePairs.get((gregorianDateChineseDatePairs.size() - 1));

            final int gregorianYearEnd        = lastpair.getFirst().year;
            final int chineseGregorianYearEnd = lastpair.getSecond().year;
            final int gregorianYears          = gregorianYearEnd - GREGORIAN_YEAR_BEGIN + 1;
            final int chineseYears            = chineseGregorianYearEnd - CHINESE_GREGORIAN_YEAR_BEGIN + 1;

            // 年 月 日
            GREGORIAN_DATE_TO_农历日期_TABLE = new 农历日期[gregorianYears][12][31];
            // 天干地支，年，月，日, 平月0/闰月1
            CHINESE_DATE_TO_公历日期_TABLE = new 公历日期[chineseYears][12][31][2];

            gregorianDateChineseDatePairs.stream().forEach(gregorianDateChineseDatePair -> {
                final 公历日期 公历日期 = gregorianDateChineseDatePair.getFirst();
                final 农历日期 农历日期 = gregorianDateChineseDatePair.getSecond();
                setChineseDate(公历日期, 农历日期);
                setGregorianDate(农历日期, 公历日期);
            });

        } catch (IOException e) {
            throw new RuntimeException("程序初始化错误", e);
        }
    }


    public 农历日期 getChineseDate(公历日期 公历日期) {
        return GREGORIAN_DATE_TO_农历日期_TABLE[公历日期.year - GREGORIAN_YEAR_BEGIN][公历日期.month - 1][公历日期.day - 1];
    }

    private void setChineseDate(公历日期 公历日期, 农历日期 农历日期) {
        GREGORIAN_DATE_TO_农历日期_TABLE[公历日期.year - GREGORIAN_YEAR_BEGIN][公历日期.month - 1][公历日期.day - 1] = 农历日期;
    }

    public 公历日期 getGregorianDate(农历日期 农历日期) {
        int leap  = 0;
        int month = 农历日期.month;
        if (month < 0) {
            leap = 1;
            month = -month;
        }
        return CHINESE_DATE_TO_公历日期_TABLE[农历日期.year - CHINESE_GREGORIAN_YEAR_BEGIN][month - 1][农历日期.day - 1][leap];
    }

    private void setGregorianDate(农历日期 农历日期, 公历日期 公历日期) {
        int leap  = 0;
        int month = 农历日期.month;
        if (month < 0) {
            leap = 1;
            month = -month;
        }
        CHINESE_DATE_TO_公历日期_TABLE[农历日期.year - CHINESE_GREGORIAN_YEAR_BEGIN][month - 1][农历日期.day - 1][leap] = 公历日期;
    }

    private static Pair<公历日期, 农历日期> csvArrayToGregorianDateChineseDatePair(String[] dateItemArr) {
        final int                            year         = Integer.parseInt(dateItemArr[0]);
        final int                            month        = Integer.parseInt(dateItemArr[1]);
        final int                            day          = Integer.parseInt(dateItemArr[2]);
        final String                         chineseYear  = dateItemArr[3];
        final int                            chineseMonth = Integer.parseInt(dateItemArr[4]);
        final int                            chineseDay   = Integer.parseInt(dateItemArr[5]);
        final 公历日期 公历日期         = new 公历日期(year, month, day);

        final 农历日期 农历日期;
        int                                  targetIntValue = 干支1900.get序号() + ((year - 1900) % 60);
        if (targetIntValue > 60) {
            targetIntValue -= 60;
        }
        final 干支 当前公里年对应的干支 = 干支.fromIntValue(targetIntValue);
        final 干支 实际干支       = 干支.valueOf(chineseYear);
        if (当前公里年对应的干支 == 实际干支) {
            农历日期 = new 农历日期(year, chineseMonth, chineseDay);
        } else {
            农历日期 = new 农历日期(year - 1, chineseMonth, chineseDay);
        }

        return new Pair<>(公历日期, 农历日期);
    }
}
