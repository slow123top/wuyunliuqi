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
public class YaoCai {
    @Id
    String yaoCaiId;
    String yaoMing;
    String yaoWei;
    String guiJing;
    String gongXiao;
    String yingYong;
    String yongFaYongLiang;

    public YaoCai() {
        this.yaoCaiId = UUID.randomUUID().toString();
    }

}
