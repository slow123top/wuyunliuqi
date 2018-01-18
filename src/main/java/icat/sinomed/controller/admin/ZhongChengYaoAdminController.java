package icat.sinomed.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import icat.sinomed.controller.ZhongChengYaoController;
import icat.sinomed.entity.APIResponse;
import icat.sinomed.entity.ZhongChengYao;
import icat.sinomed.repository.ZhongChengYaoRepositoty;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by liucong on  16-4-10-010.
 */
@RestController
@RequestMapping("/api/admin/zhongchengyao")
public class ZhongChengYaoAdminController {

    @Autowired
    ZhongChengYaoRepositoty zhongChengYaoRepositoty;

    @Autowired
    ZhongChengYaoController zhongChengYaoController;


    @RequestMapping(value = "/fuzzy", method = RequestMethod.GET)
    public APIResponse fuzzyQuery(
            @RequestParam("fuzzy") String fuzzy) {
        return zhongChengYaoController.fuzzyQuery(fuzzy);
    }

    @RequestMapping(path = {"/add", "/update"}, method = RequestMethod.POST)
    public APIResponse add(@RequestBody ZhongChengYao zhongChengYao) {
        final ZhongChengYao savedObject = zhongChengYaoRepositoty.save(zhongChengYao);
        return APIResponse.newSuccessApiResponse().setData(savedObject);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(@RequestParam("id") String id) {
        zhongChengYaoRepositoty.delete(id);
        return APIResponse.newSuccessApiResponse();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", defaultValue = "0",
                    value = "页码(0..N), 默认值为0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", defaultValue = "20",
                    value = "每页条数, 默认值为20"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "排序格式为: property(,asc|desc). " +
                            "默认排序是升序(ascending). " +
                            "sort参数支持多个并列.")
    })
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public APIResponse list(@ApiIgnore Pageable pageable) {
        final Page<ZhongChengYao> pagedContent = zhongChengYaoRepositoty.findAll(pageable);
        return APIResponse.newSuccessApiResponse().setData(pagedContent);
    }


}
