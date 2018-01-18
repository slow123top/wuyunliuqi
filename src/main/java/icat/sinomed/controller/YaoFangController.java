package icat.sinomed.controller;

import icat.sinomed.entity.APIResponse;
import icat.sinomed.repository.YaoFangRepository;
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
public class YaoFangController {

    @Autowired
    YaoFangRepository yaoFangRepository;

    @ResponseBody
    @RequestMapping(value = "/api/yaofangs", method = RequestMethod.GET)
    public APIResponse all(){
        return APIResponse.newSuccessApiResponse().setData(yaoFangRepository.findAll());
    }

    @ResponseBody
    @RequestMapping(value = "/api/yaofang/fuzzy", method = RequestMethod.GET)
    public APIResponse fuzzyQuery(@RequestParam("fuzzy") String fuzzy){
        return APIResponse.newSuccessApiResponse().setData(yaoFangRepository.fuzzy(fuzzy));
    }
}
