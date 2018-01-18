package icat.sinomed.controller;

import icat.sinomed.entity.APIResponse;
import icat.sinomed.entity.User;
import icat.sinomed.repository.UserRepository;
import icat.sinomed.service.CaptchaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by liucong on  16-4-5-005.
 */
@Slf4j
@Controller
public class UserController {

    public static final String USER_SESSION_KEY = "user";
    @Autowired
    UserRepository userRepository;

    @Autowired
    CaptchaService captchaService;

    @Autowired
    Validator validator;

    @RequestMapping(path = "/captcha", method = RequestMethod.GET)
    public void captcha(HttpSession session, HttpServletResponse response) {
        try {
            captchaService.writeCaptcha(session, response);
        } catch (IOException e) {
            log.error("写入验证码到response过程出错", e);
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String signupPage() {
        return "register";
    }

    @ResponseBody
    @RequestMapping(path = {"/register"})
    public APIResponse apiSignup(HttpSession session,
                            @RequestParam(name = "username") String username,
                            @RequestParam(name = "password") String password,
                            @RequestParam(name = "displayName") String displayName,
                            @RequestParam(name = "captcha") String captcha) {
        final APIResponse r;
        final CaptchaService.Validity validity = captchaService.validateCaptcha(session, captcha);
        if (validity != CaptchaService.Validity.VALID) {
            r = new APIResponse("验证码不正确", APIResponse.Status.ERROR);
            return r;
        }

        final User userExist = userRepository.findByUsername(username);
        if (userExist != null) {
            r = new APIResponse("用户名已被使用，请换个名字吧", APIResponse.Status.ERROR);
        } else {
            final User user = new User().setUsername(username).setPassword(password).setDisplayName(displayName);
            final Set<ConstraintViolation<User>> validate = validator.validate(user);
            if (validate.size() > 0) {
                r = new APIResponse("参数不合法", APIResponse.Status.ERROR).setDataValue("errors", "用户名或密码不符合格式要求");
                if (log.isDebugEnabled()) {
                    final List<String> messages = validate.stream()
                            .map(violation -> violation.getPropertyPath() + violation.getMessage())
                            .collect(Collectors.toList());
                    log.debug("用户注册校验失败，不合法的用户", messages);
                }

            } else {
                final User save = userRepository.save(user);
                if (save != null) {
                    r = new APIResponse("注册成功，请登陆吧", APIResponse.Status.SUCCESS);
                } else {
                    r = new APIResponse("注册失败，请联系管理员", APIResponse.Status.ERROR);
                }
            }
        }

        return r;
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }


    @ResponseBody
    @RequestMapping(path = {"/login"}, method = RequestMethod.POST)
    public APIResponse login(HttpSession session,
                        @RequestParam("captcha") String captcha,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password) {
        final CaptchaService.Validity validity = captchaService.validateCaptcha(session, captcha);
        final APIResponse r;
        if (validity == CaptchaService.Validity.VALID) {
            final User userFound = userRepository.findByUsername(username);
            if (userFound != null) {
                final String passwordHash = userFound.getPasswordHash();
                final boolean isPasswordCorrect = BCrypt.checkpw(password, passwordHash);
                if (isPasswordCorrect) {
                    r = new APIResponse("登陆成功", APIResponse.Status.SUCCESS, "").setDataValue("jumpUrl", "/wuyunliuqitu");
                    session.setAttribute(USER_SESSION_KEY, userFound);
                    return r;
                }
            }
            r = new APIResponse("登陆失败，用户名或密码错误!", APIResponse.Status.ERROR, "");
        } else {
            r = new APIResponse("登陆失败,验证码无效!", APIResponse.Status.ERROR, validity.toString());
        }
        return r;
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
