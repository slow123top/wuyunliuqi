package icat.sinomed.util;

import java.util.HashMap;

/**
 * Created by liucong on  16-4-3-003.
 */
public enum 节气 {
    立春(1),
    雨水(2),
    惊蛰(3),
    春分(4),
    清明(5),
    谷雨(6),
    立夏(7),
    小满(8),
    芒种(9),
    夏至(10),
    小暑(11),
    大暑(12),
    立秋(13),
    处暑(14),
    白露(15),
    秋分(16),
    寒露(17),
    霜降(18),
    立冬(19),
    小雪(20),
    大雪(21),
    冬至(22),
    小寒(23),
    大寒(24);

    int intValue;

    private static final HashMap<Integer, 节气> INT_VALUE_NAME_MAP = new HashMap<>();

    static {
        final 节气[] values = values();
        for (节气 value : values) {
            INT_VALUE_NAME_MAP.put(value.getIntValue(), value);
        }
    }

    节气(int value) {
        this.intValue = value;
    }

    public int getIntValue() {
        return this.intValue;
    }

    public static 节气 fromIntValue(int value) {
        return INT_VALUE_NAME_MAP.get(value);
    }

    /**
     * 判断当前节气是否在某两个节气中间，包含begin，不含end
     * @param begin 开始节气，包含
     * @param end 截止节气，不含
     * @return 当前节气在[开始节气，截止节气)中，则为true否则false
     */
    public boolean isInRange(节气 begin, 节气 end){
        if(this == begin){
            return true;
        }

        int b = begin.intValue;
        int e = end.intValue;

        if(b > e){
            return intValue < e && intValue > b;
        }else {
            return intValue > b && intValue < e;
        }


    }

}
