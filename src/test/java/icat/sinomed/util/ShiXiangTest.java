package icat.sinomed.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import icat.sinomed.SinomedApplication;

/**
 * Created by liucong on  16-4-3-003.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SinomedApplication.class)
public class ShiXiangTest {

    @Autowired
    时相.时相服务 时相服务;

    @Test
    public void testLocalDateTimeConvertToShiXiang() {
        final LocalDateTime time20141128 = LocalDateTime.of(2014, 11, 28, 0, 0);
        final LocalDateTime time20160306 = LocalDateTime.of(2016, 3, 6, 0, 0);
        final LocalDateTime time19650731 = LocalDateTime.of(1965, 7, 31, 0, 0);

        final 时相 时相20141128 = 时相服务.fromLocalDateTime(time20141128);
        final 时相 时相20160306 = 时相服务.fromLocalDateTime(time20160306);
        final 时相 时相19650731 = 时相服务.fromLocalDateTime(time19650731);

        final 时相 时相20141128正确的值 = new 时相(气.少阴君火, 气.阳明燥金, 气.太阴湿土, 气.太阳寒水, 气.阳明燥金, 时相.标志_阳);
        final 时相 时相20160306正确的值 = new 时相(气.少阳相火, 气.少阴君火, 气.太阳寒水, 气.厥阴风木, 气.厥阴风木, 时相.标志_阳);
        final 时相 时相19650731正确的值 = new 时相(气.厥阴风木, 气.少阴君火, 气.阳明燥金, 气.太阴湿土, 气.少阳相火, 时相.标志_阳);

        Assert.assertEquals(时相20141128正确的值, 时相20141128);
        Assert.assertEquals(时相20160306正确的值, 时相20160306);
        Assert.assertEquals(时相19650731正确的值, 时相19650731);

    }

}
