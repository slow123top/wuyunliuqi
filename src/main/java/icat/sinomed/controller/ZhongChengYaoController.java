package icat.sinomed.controller;

import icat.sinomed.entity.APIResponse;
import icat.sinomed.repository.ZhongChengYaoRepositoty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liucong on  16-4-10-010.
 */
@Controller
public class ZhongChengYaoController {

    @Autowired
    ZhongChengYaoRepositoty zhongChengYaoRepositoty;

    @ApiOperation(value = "获取所有中药方", produces = "application/json")
    @ResponseBody
    @RequestMapping(value = "/api/zhongchengyaos", method = RequestMethod.GET)
    public APIResponse all(){
        return APIResponse.newSuccessApiResponse().setData(zhongChengYaoRepositoty.findAll());
    }

    @ApiOperation(value = "模糊查询药方", notes = "这个操作理论会比较费时，注意性能", produces = "application/json")
    @ResponseBody
    @RequestMapping(value = "/api/zhongchengyao/fuzzy", method = RequestMethod.GET)
    public APIResponse fuzzyQuery(
            @ApiParam(name="fuzzy", defaultValue = "口服")
            @RequestParam("fuzzy") String fuzzy){
        return APIResponse.newSuccessApiResponse().setData(zhongChengYaoRepositoty.fuzzy(fuzzy));
    }

}
