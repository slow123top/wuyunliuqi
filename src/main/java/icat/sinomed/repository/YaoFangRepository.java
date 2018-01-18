package icat.sinomed.repository;

import icat.sinomed.entity.YaoFang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by liucong on  16-4-10-010.
 */
@Repository
public interface YaoFangRepository extends JpaRepository<YaoFang, String> {

    @Query("select yf from YaoFang yf where " +
            "yf.fangMing like %?1% or " +
            "yf.chengFen like %?1% or " +
            "yf.gongXiao like %?1% or " +
            "yf.zhuZhi like %?1% or " +
            "yf.yongFa like %?1% or " +
            "yf.fangJie like %?1% or " +
            "yf.linChuangYingYong like %?1% or " +
            "yf.zhuYiShiXiang like %?1%")
    Iterable<YaoFang> fuzzy(String fuzzy);

}
