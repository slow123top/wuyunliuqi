package icat.sinomed.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by liucong on  16-4-10-010.
 */
@Entity
@Data
public class ZhongChengYao {
    @Id
    String zhongChengYaoId;
    String leiBie;
    String pinMing;
    String guiGe;
    String wenHaoShuLiang;
    String yaoPinLeiXing;
    String zhuYaoChengFen;
    String yongFaYongLiang;
    String fuYongTianShu;
    String shiYongRenQun;
    String tongMingJingPin;
    String tongXiaoChanPin;

    public ZhongChengYao() {
        this.zhongChengYaoId = UUID.randomUUID().toString();
    }
}
