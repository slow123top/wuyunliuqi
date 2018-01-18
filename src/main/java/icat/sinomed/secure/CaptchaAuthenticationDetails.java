package icat.sinomed.secure;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

import icat.sinomed.service.CaptchaService;

/**
 * Created by liucong on  16-4-6-006.
 */
public class CaptchaAuthenticationDetails //extends WebAuthenticationDetails
{
    /**
     * Records the remote address and will also set the session Id if a session already exists (it won't create one).
     *
     * @param request that the authentication request was received from
     */

    private final String userCaptcha;
    private final String serverCaptcha;

    public CaptchaAuthenticationDetails(HttpServletRequest request) {
//        super(request);
        this.userCaptcha = request.getParameter("captcha");
        this.serverCaptcha = (String) WebUtils.getSessionAttribute(request, CaptchaService.CAPTCHA_SESSION_NAME);
    }

    public String getUserCaptcha() {
        return userCaptcha;
    }

    public String getServerCaptcha() {
        return serverCaptcha;
    }
}
