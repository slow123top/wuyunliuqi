package icat.sinomed.service;

import com.github.cage.Cage;
import com.github.cage.GCage;
import com.github.cage.token.RandomTokenGenerator;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liucong on  16-4-6-006.
 */
@Service
@Slf4j
public class CaptchaService {

    public static final String               CAPTCHA_SESSION_NAME = "_captcha";
    protected final     Cage                 cage                 = new GCage();
    protected           RandomTokenGenerator randomTokenGenerator = new RandomTokenGenerator(new Random(), 4);

    public enum Validity {
        /**
         * 有效的
         */
        VALID,
        /**
         * 无效的
         */
        INVALID,
        /**
         * 过期的
         */
        EXPERIED
    }

    public Validity validateCaptcha(HttpSession session, String captcha) {
        if (StringUtils.isEmpty(captcha)) {
            return Validity.INVALID;
        }
        final Object sessionCaptcha = session.getAttribute(CAPTCHA_SESSION_NAME);
        session.removeAttribute(CAPTCHA_SESSION_NAME);
        log.debug("captcha in session : {}, captcha to be validate : {}", sessionCaptcha, captcha);
        if (sessionCaptcha == null) {
            return Validity.EXPERIED;
        }
        if (!(sessionCaptcha instanceof String)) {
            throw new RuntimeException("session中的验证码不是字符串，是否把非验证码的对象设置为了" + CAPTCHA_SESSION_NAME + "?");
        }
        final String sessionCaptchaString = (String) sessionCaptcha;

        if (captcha.equalsIgnoreCase(sessionCaptchaString)) {
            return Validity.VALID;
        } else {
            return Validity.INVALID;
        }
    }

    private void setResponseHeaders(HttpServletResponse resp) {
        final long time = System.currentTimeMillis();
        resp.setContentType("image/" + cage.getFormat());
        resp.setHeader("Cache-Control", "no-cache, no-store");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Last-Modified", time);
        resp.setDateHeader("Date", time);
        resp.setDateHeader("Expires", time);
    }

    public void writeCaptcha(HttpSession session, HttpServletResponse response) throws IOException {
        final String token = randomTokenGenerator.next();
        session.setAttribute(CAPTCHA_SESSION_NAME, token);
        setResponseHeaders(response);
        cage.draw(token, response.getOutputStream());
        log.debug("captcha generated : {}", token);
    }


}
