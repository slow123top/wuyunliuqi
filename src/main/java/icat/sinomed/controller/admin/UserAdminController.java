package icat.sinomed.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import icat.sinomed.entity.APIResponse;
import icat.sinomed.entity.User;
import icat.sinomed.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

import static icat.sinomed.filter.LoginFilter.USER_SESSION_KEY;

/**
 * Created by liucong on  16-4-10-010.
 */
@Slf4j
@RestController
@RequestMapping("/api/admin/user")
@Api(value = "用户管理", description = "提供给管理员的用户增删改查")
public class UserAdminController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public APIResponse add(@RequestBody User user) {
        final User savedUser = userRepository.save(user);
        if (savedUser != null) {
            savedUser.setPassword("").setPasswordHash("");
        }
        return APIResponse.newSuccessApiResponse().setData(savedUser);
    }

    @ApiOperation(value = "修改用户信息", notes = "password为空则不修改，password有值则覆盖")
    @RequestMapping(path = {"/update"}, method = RequestMethod.POST)
    public APIResponse update(@RequestBody User user) {
        User r = null;
        if (user.getPasswordHash() == null) {
            final int i = userRepository.updateUserIgnorePassword(user.getUuid(), user.getUsername(), user.getDisplayName(), user.getRole(), user.isEnabled());
            if (i == 1) {
                r = user;
            }
        } else {
            r = userRepository.save(user);
        }

        if(r != null){
            return APIResponse.newSuccessApiResponse().setData(r);
        }else{
            return APIResponse.newErrorApiResponse().setData(r);
        }

    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(@RequestParam("id") String id) {
        userRepository.delete(id);
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
        Pageable p;
        if(pageable.getSort() == null){
            p = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.DESC, "addTime");
        }else{
            p = pageable;
        }

        final Page<User> users = userRepository.findAll(p);
        return APIResponse.newSuccessApiResponse().setData(users);
    }


    @ApiOperation(value = "获取用户信息", notes = "传入参数id，则获取对应信息，否则获取当前用户信息")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public APIResponse get(@ApiIgnore HttpSession session, @RequestParam(name = "id", required = false) String id) {
        final User user;
        if (id == null || id.trim().length() == 0) {
            user = (User) session.getAttribute(USER_SESSION_KEY);
        } else {
            user = userRepository.findOne(id);
        }
        if (user != null) {
            user.setPassword("").setPasswordHash("");
        }
        return APIResponse.newSuccessApiResponse().setData(user);
    }

}
