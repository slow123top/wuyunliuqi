package icat.sinomed.secure;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liucong on  16-4-6-006.
 */
@Component
public class CaptchaAuthenticationDetailsSource implements
        AuthenticationDetailsSource<HttpServletRequest, CaptchaAuthenticationDetails> {

    @Override
    public CaptchaAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new CaptchaAuthenticationDetails(context);
    }
}
