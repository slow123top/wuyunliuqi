package icat.sinomed.util;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashMap;

/**
 * Created by liucong on  16-3-31-031.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum 天干 {
    甲("甲", 1),
    乙("乙", 2),
    丙("丙", 3),
    丁("丁", 4),
    戊("戊", 5),
    己("己", 6),
    庚("庚", 7),
    辛("辛", 8),
    壬("壬", 9),
    癸("癸", 10);

    final String 名称;
    final int    序号;
    private static final HashMap<Integer, 天干> INT_VALUE_NAME_MAP = new HashMap<>();

    static {
        final 天干[] values = values();
        for (天干 value : values) {
            INT_VALUE_NAME_MAP.put(value.get序号(), value);
        }
    }

    天干(String 名称, int value) {
        this.名称 = 名称;
        this.序号 = value;
    }

    public int get序号() {
        return this.序号;
    }

    public String get名称() {
        return 名称;
    }

    public static 天干 fromIntValue(int value) {
        return INT_VALUE_NAME_MAP.get(value);
    }

}
