package icat.sinomed.controller;

import icat.sinomed.entity.APIResponse;
import icat.sinomed.repository.YaoCaiRepository;
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
public class YaoCaiController {
    @Autowired
    YaoCaiRepository yaoCaiRepository;

    @ResponseBody
    @RequestMapping(value = "/api/yaocais", method = RequestMethod.GET)
    public APIResponse all(){
        return APIResponse.newSuccessApiResponse().setData(yaoCaiRepository.findAll());
    }

    @ResponseBody
    @RequestMapping(value = "/api/yaocai/fuzzy", method = RequestMethod.GET)
    public APIResponse fuzzyQuery(@RequestParam("fuzzy") String fuzzy){
        return APIResponse.newSuccessApiResponse().setData(yaoCaiRepository.fuzzy(fuzzy));
    }

}
