package icat.sinomed.controller;

import icat.sinomed.entity.APIResponse;
import icat.sinomed.util.时相;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created by liucong on  16-4-6-006.
 */
@Slf4j
@Controller
public class WuYunLiuQiController {

    @Autowired
    时相.时相服务 当前时相服务;

    @ResponseBody
    @RequestMapping(path = "/api/wuyunliuqitu", method = RequestMethod.POST)
    public APIResponse apiWuyunliutitu(
            @RequestParam("date") String dateString) {
        final Logger log = LoggerFactory.getLogger(WuYunLiuQiController.class);
        final APIResponse apiResponse = new APIResponse();

        try {
            final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd.HH:mm:ss");
            final LocalDateTime     time              = LocalDateTime.parse(dateString, dateTimeFormatter);

            final 时相 时相值 = 当前时相服务.fromLocalDateTime(time);
            apiResponse.setStatus(APIResponse.Status.SUCCESS);
            apiResponse.setDataValue("shixiang", 时相值);
        } catch (Exception e) {

            log.error("发生错误", e);
            apiResponse.setStatus(APIResponse.Status.ERROR);
        }
        return apiResponse;
    }


    @RequestMapping(path = {"/wuyunliuqitu"}, method = RequestMethod.GET)
    public String apiWuyunliutitu() {
        return "wuyunliuqitu";
    }

}
