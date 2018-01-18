package icat.sinomed.controller.admin;

import icat.sinomed.controller.YaoFangController;
import icat.sinomed.entity.APIResponse;
import icat.sinomed.entity.YaoFang;
import icat.sinomed.repository.YaoFangRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by liucong on  16-4-10-010.
 */
@RestController
@RequestMapping("/api/admin/yaofang")
public class YaoFangAdminController {

    @Autowired
    YaoFangRepository yaoFangRepository;

    @Autowired
    YaoFangController yaoFangController;


    @RequestMapping(value = "/fuzzy", method = RequestMethod.GET)
    public APIResponse fuzzyQuery(@RequestParam("fuzzy") String fuzzy) {
        return yaoFangController.fuzzyQuery(fuzzy);
    }

    @RequestMapping(path = {"/add", "/update"}, method = RequestMethod.POST)
    public APIResponse add(@RequestBody YaoFang yaoFang) {
        final YaoFang savedObject = yaoFangRepository.save(yaoFang);
        return APIResponse.newSuccessApiResponse().setData(savedObject);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(@RequestParam("id") String id) {
        yaoFangRepository.delete(id);
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
        final Page<YaoFang> pagedContent = yaoFangRepository.findAll(pageable);
        return APIResponse.newSuccessApiResponse().setData(pagedContent);
    }

}
