package icat.sinomed.util;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by liucong on  16-4-3-003.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum 气 {
    厥阴风木(1, 运.木, "厥阴风木", 410),
    少阴君火(2, 运.火, "少阴君火", 115),
    少阳相火(3, 运.火, "少阳相火", 17),
    太阴湿土(4, 运.土, "太阴湿土", 126),
    阳明燥金(5, 运.金, "阳明燥金", 28),
    太阳寒水(6, 运.水, "太阳寒水", 39);

    public final int                         步;
    public final int                         数;
    public final String                      名;
    public final icat.sinomed.util.运 气之运;


    气(int 步, icat.sinomed.util.运 气之运, String 名, int 数) {
        this.步 = 步;
        this.数 = 数;
        this.气之运 = 气之运;
        this.名 = 名;
    }


}
