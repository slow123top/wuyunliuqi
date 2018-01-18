package icat.sinomed.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by liucong on  16-4-6-006.
 */
@Component
public class CaptchaDaoAuthenticationProvider extends DaoAuthenticationProvider {


    public CaptchaDaoAuthenticationProvider(){
        this.setPasswordEncoder(new BCryptPasswordEncoder());
    }

    @Autowired
    @Override
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }



    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        super.additionalAuthenticationChecks(userDetails, authentication);

        final Object details = authentication.getDetails();

        Object obj = authentication.getDetails();
        if (!(obj instanceof CaptchaAuthenticationDetails)) {
            throw new InsufficientAuthenticationException(
                    "Captcha details not found.");
        }

        CaptchaAuthenticationDetails captchaDetails = (CaptchaAuthenticationDetails) obj;
        String captcha = captchaDetails.getServerCaptcha();
        if (captcha != null) {
            String actual = captchaDetails.getUserCaptcha();
            if (!captcha.equals(actual)) {
                throw new BadCredentialsException("验证码不匹配");
            }
        }

    }
}
