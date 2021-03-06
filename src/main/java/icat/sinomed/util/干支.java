package icat.sinomed.util;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashMap;

/**
 * Created by liucong on  16-3-31-031.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum 干支 {

    甲子("甲子", 天干.甲, 地支.子, 1),
    乙丑("乙丑", 天干.乙, 地支.丑, 2),
    丙寅("丙寅", 天干.丙, 地支.寅, 3),
    丁卯("丁卯", 天干.丁, 地支.卯, 4),
    戊辰("戊辰", 天干.戊, 地支.辰, 5),
    己巳("己巳", 天干.己, 地支.巳, 6),
    庚午("庚午", 天干.庚, 地支.午, 7),
    辛未("辛未", 天干.辛, 地支.未, 8),
    壬申("壬申", 天干.壬, 地支.申, 9),
    癸酉("癸酉", 天干.癸, 地支.酉, 10),
    甲戌("甲戌", 天干.甲, 地支.戌, 11),
    乙亥("乙亥", 天干.乙, 地支.亥, 12),
    丙子("丙子", 天干.丙, 地支.子, 13),
    丁丑("丁丑", 天干.丁, 地支.丑, 14),
    戊寅("戊寅", 天干.戊, 地支.寅, 15),
    己卯("己卯", 天干.己, 地支.卯, 16),
    庚辰("庚辰", 天干.庚, 地支.辰, 17),
    辛巳("辛巳", 天干.辛, 地支.巳, 18),
    壬午("壬午", 天干.壬, 地支.午, 19),
    癸未("癸未", 天干.癸, 地支.未, 20),
    甲申("甲申", 天干.甲, 地支.申, 21),
    乙酉("乙酉", 天干.乙, 地支.酉, 22),
    丙戌("丙戌", 天干.丙, 地支.戌, 23),
    丁亥("丁亥", 天干.丁, 地支.亥, 24),
    戊子("戊子", 天干.戊, 地支.子, 25),
    己丑("己丑", 天干.己, 地支.丑, 26),
    庚寅("庚寅", 天干.庚, 地支.寅, 27),
    辛卯("辛卯", 天干.辛, 地支.卯, 28),
    壬辰("壬辰", 天干.壬, 地支.辰, 29),
    癸巳("癸巳", 天干.癸, 地支.巳, 30),
    甲午("甲午", 天干.甲, 地支.午, 31),
    乙未("乙未", 天干.乙, 地支.未, 32),
    丙申("丙申", 天干.丙, 地支.申, 33),
    丁酉("丁酉", 天干.丁, 地支.酉, 34),
    戊戌("戊戌", 天干.戊, 地支.戌, 35),
    己亥("己亥", 天干.己, 地支.亥, 36),
    庚子("庚子", 天干.庚, 地支.子, 37),
    辛丑("辛丑", 天干.辛, 地支.丑, 38),
    壬寅("壬寅", 天干.壬, 地支.寅, 39),
    癸卯("癸卯", 天干.癸, 地支.卯, 40),
    甲辰("甲辰", 天干.甲, 地支.辰, 41),
    乙巳("乙巳", 天干.乙, 地支.巳, 42),
    丙午("丙午", 天干.丙, 地支.午, 43),
    丁未("丁未", 天干.丁, 地支.未, 44),
    戊申("戊申", 天干.戊, 地支.申, 45),
    己酉("己酉", 天干.己, 地支.酉, 46),
    庚戌("庚戌", 天干.庚, 地支.戌, 47),
    辛亥("辛亥", 天干.辛, 地支.亥, 48),
    壬子("壬子", 天干.壬, 地支.子, 49),
    癸丑("癸丑", 天干.癸, 地支.丑, 50),
    甲寅("甲寅", 天干.甲, 地支.寅, 51),
    乙卯("乙卯", 天干.乙, 地支.卯, 52),
    丙辰("丙辰", 天干.丙, 地支.辰, 53),
    丁巳("丁巳", 天干.丁, 地支.巳, 54),
    戊午("戊午", 天干.戊, 地支.午, 55),
    己未("己未", 天干.己, 地支.未, 56),
    庚申("庚申", 天干.庚, 地支.申, 57),
    辛酉("辛酉", 天干.辛, 地支.酉, 58),
    壬戌("壬戌", 天干.壬, 地支.戌, 59),
    癸亥("癸亥", 天干.癸, 地支.亥, 60);

    final String 名称;
    final int    序号;
    final 天干     干;
    final 地支     支;


    private static final HashMap<Integer, 干支> INT_VALUE_NAME_MAP = new HashMap<>();

    static {
        final 干支[] values = values();
        for (干支 value : values) {
            INT_VALUE_NAME_MAP.put(value.get序号(), value);
        }
    }

    干支(String 名称, 天干 干, 地支 支, int 序号) {
        this.名称 = 名称;
        this.序号 = 序号;
        this.干 = 干;
        this.支 = 支;
    }

    public int get序号() {
        return this.序号;
    }

    public static 干支 fromIntValue(int value) {
        return INT_VALUE_NAME_MAP.get(value);
    }

    public 天干 干() {
        return 干;
    }

    public 地支 支() {
        return 支;
    }

    public String get名称() {
        return 名称;
    }
}
