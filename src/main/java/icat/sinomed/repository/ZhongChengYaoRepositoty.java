package icat.sinomed.repository;

import icat.sinomed.entity.ZhongChengYao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by liucong on  16-4-10-010.
 */
@Repository
public interface ZhongChengYaoRepositoty extends JpaRepository<ZhongChengYao, String> {


    @Query("select zcy from ZhongChengYao zcy where " +
            "zcy.leiBie like %?1% or " +
            "zcy.pinMing like %?1% or " +
            "zcy.guiGe like %?1% or " +
            "zcy.wenHaoShuLiang like %?1% or " +
            "zcy.yaoPinLeiXing like %?1% or " +
            "zcy.zhuYaoChengFen like %?1% or " +
            "zcy.yongFaYongLiang like %?1% or " +
            "zcy.fuYongTianShu like %?1% or " +
            "zcy.shiYongRenQun like %?1% or " +
            "zcy.tongMingJingPin like %?1% or " +
            "zcy.tongXiaoChanPin like %?1%")
    Iterable<ZhongChengYao> fuzzy(String fuzzy);

}
