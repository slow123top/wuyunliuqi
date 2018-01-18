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
public class YaoFang {
    @Id
    String yaoFangId;
    String fangMing;
    String chengFen;
    String gongXiao;
    String zhuZhi;
    String yongFa;
    String fangJie;
    String linChuangYingYong;
    String zhuYiShiXiang;

    public YaoFang() {
        this.yaoFangId = UUID.randomUUID().toString();
    }
}
