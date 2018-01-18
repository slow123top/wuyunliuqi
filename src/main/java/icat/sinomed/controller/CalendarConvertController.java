package icat.sinomed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import icat.sinomed.entity.APIResponse;
import icat.sinomed.util.公历日期;
import icat.sinomed.util.农历日期;
import icat.sinomed.util.日历转换工具;


/**
 * Created by liucong on  16-4-6-006.
 */
@Controller
public class CalendarConvertController {

    @Autowired
    日历转换工具 当前日历转换工具;

    @ResponseBody
    @RequestMapping(path = "/api/calendar-convert", method = RequestMethod.POST)
    public APIResponse apiCalendarConvert(
            @RequestParam("date") String date,
            @RequestParam(name = "ChineseToGregorian", required = false) String chineseToGregorian) {
        final String[] dateArr = date.split("-");
        int            y       = Integer.parseInt(dateArr[0]);
        int            m       = Integer.parseInt(dateArr[1]);
        int            d       = Integer.parseInt(dateArr[2]);

        final APIResponse apiResponse = new APIResponse();
        if (chineseToGregorian != null) {
            // 农历转公历
            if (m > 12) {
                m = -(m - 12);
            }
            final 公历日期 公历日期 = 当前日历转换工具.getGregorianDate(new 农历日期(y, m, d));
            apiResponse.setDataValue("dateConverted", 公历日期);
        } else {
            // 公历转农历
            final 农历日期 农历日期 = 当前日历转换工具.getChineseDate(new 公历日期(y, m, d));
            apiResponse.setDataValue("dateConverted", 农历日期);
        }
        apiResponse.setStatus(APIResponse.Status.SUCCESS);
        return apiResponse;
    }

}
