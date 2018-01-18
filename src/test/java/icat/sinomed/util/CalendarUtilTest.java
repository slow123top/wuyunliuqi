package icat.sinomed.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import icat.sinomed.SinomedApplication;

/**
 * Created by liucong on  16-4-3-003.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SinomedApplication.class)
public class CalendarUtilTest {

    @Autowired
    日历转换工具 当前日历转换工具;

    @Test
    public void 农历转公历(){
        final 农历日期 date       = new 农历日期("己亥", 1899, 12, 1);
        final 公历日期 公历日期       = 当前日历转换工具.getGregorianDate(date);
        final 公历日期 target公历日期 = new 公历日期(1900, 1, 1);
        Assert.assertEquals(target公历日期, 公历日期);
    }

}
