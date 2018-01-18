package icat.sinomed.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import icat.sinomed.entity.APIResponse;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/wuyunliuqitu";
    }

    @RequestMapping(value = "/building", method = RequestMethod.GET)
    public Object building() {
        return "building";
    }

    @RequestMapping("/api/403")
    public APIResponse api403() {
        return new APIResponse("未登录，无权使用此接口", APIResponse.Status.ERROR, "403");
    }

}
