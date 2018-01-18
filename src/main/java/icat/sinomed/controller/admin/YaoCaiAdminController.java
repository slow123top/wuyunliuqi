package icat.sinomed.controller.admin;

import icat.sinomed.controller.YaoCaiController;
import icat.sinomed.entity.APIResponse;
import icat.sinomed.entity.YaoCai;
import icat.sinomed.repository.YaoCaiRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by liucong on  16-4-10-010.
 */
@Slf4j
@RestController
@RequestMapping("/api/admin/yaocai")
public class YaoCaiAdminController {
    @Autowired
    YaoCaiRepository yaoCaiRepository;

    @Autowired
    YaoCaiController yaoCaiController;


    @RequestMapping(value = "/fuzzy", method = RequestMethod.GET)
    public APIResponse fuzzyQuery(@RequestParam("fuzzy") String fuzzy) {
        return yaoCaiController.fuzzyQuery(fuzzy);
    }


    @RequestMapping(path = {"/add", "/update"}, method = RequestMethod.POST)
    public APIResponse add(@RequestBody YaoCai yaoCai) {
        final YaoCai savedYaoCai = yaoCaiRepository.save(yaoCai);
        return APIResponse.newSuccessApiResponse().setData(savedYaoCai);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(@RequestParam("id") String id) {
        yaoCaiRepository.delete(id);
        return APIResponse.newSuccessApiResponse();
    }

    @ApiOperation(
            value = "列出药材",
            notes = "调用API示例：按照yaoMing(药名)字段降序排列，第四页，每页大小为2条。" +
                    "/api/admin/yaocai/list?sort=yaoMing,desc&page=4&size=2"

    )
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
        final Page<YaoCai> yaoCais = yaoCaiRepository.findAll(pageable);
        return APIResponse.newSuccessApiResponse().setData(yaoCais);
    }


}
