package icat.sinomed.repository;

import icat.sinomed.entity.YaoCai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by liucong on  16-4-10-010.
 */
@Repository
public interface YaoCaiRepository extends JpaRepository<YaoCai, String> {

    @Query("select yc from YaoCai yc where " +
            "yc.yaoMing like %?1% or " +
            "yc.yaoWei like %?1% or " +
            "yc.guiJing like %?1% or " +
            "yc.gongXiao like %?1% or " +
            "yc.yingYong like %?1% or " +
            "yc.yongFaYongLiang like %?1%")
    Iterable<YaoCai> fuzzy(String fuzzy);
}
