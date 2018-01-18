package icat.sinomed.secure;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import icat.sinomed.service.CaptchaService;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by liucong on  16-4-6-006.
 */
@Slf4j
@Component
public class CaptchaCaptureFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String captcha = request.getParameter("captcha");
        if(captcha!= null){
            log.debug("captcha captured : {}", captcha);
            request.setAttribute("captcha", captcha);

            final HttpSession session = request.getSession();
            final String      serverCaptcha = (String)session.getAttribute(CaptchaService.CAPTCHA_SESSION_NAME);

            log.debug("{}, {}", serverCaptcha, captcha);

            if(!captcha.equals(serverCaptcha)){
                response.sendRedirect("/login?error");
                return;
            }

        }




        filterChain.doFilter(request,response);



    }
}
