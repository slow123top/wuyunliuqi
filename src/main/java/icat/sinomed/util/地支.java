package icat.sinomed.util;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashMap;

/**
 * Created by liucong on  16-3-31-031.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum 地支 {
    子("子", 1),
    丑("丑", 2),
    寅("寅", 3),
    卯("卯", 4),
    辰("辰", 5),
    巳("巳", 6),
    午("午", 7),
    未("未", 8),
    申("申", 9),
    酉("酉", 10),
    戌("戌", 11),
    亥("亥", 12);

    final String 名称;
    final int    序号;

    private static final HashMap<Integer, 地支> INT_VALUE_NAME_MAP = new HashMap<>();

    static {
        final 地支[] values = values();
        for (地支 value : values) {
            INT_VALUE_NAME_MAP.put(value.get序号(), value);
        }
    }

    地支(String 名称, int value) {
        this.名称 = 名称;
        this.序号 = value;
    }

    public int get序号() {
        return this.序号;
    }

    public String get名称() {
        return 名称;
    }

    public static 地支 fromIntValue(int value) {
        return INT_VALUE_NAME_MAP.get(value);
    }

}
