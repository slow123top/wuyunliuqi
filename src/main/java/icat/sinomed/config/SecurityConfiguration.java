package icat.sinomed.config;

import icat.sinomed.secure.CaptchaAuthenticationDetailsSource;
import icat.sinomed.secure.CaptchaCaptureFilter;
import icat.sinomed.secure.CaptchaDaoAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by liucong on  16-4-5-005.
 */
//@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    CaptchaCaptureFilter captchaCaptureFilter;

    @Autowired
    CaptchaDaoAuthenticationProvider captchaDaoAuthenticationProvider;

    @Autowired
    CaptchaAuthenticationDetailsSource captchaAuthenticationDetailsSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                    .csrf().ignoringAntMatchers("/h2-console/**", "/api/**")
                .and()
                    .headers().frameOptions().sameOrigin()
                .and()
                    .authorizeRequests()
                    .antMatchers("/assets/**", "/css/**", "/js/**", "/img/**").permitAll()
                    .antMatchers("/signup/**", "/api/signup/**", "/captcha/**").permitAll()
                    .anyRequest().authenticated()
                    .antMatchers("/admin/**").fullyAuthenticated()
                .and()
                    .formLogin().authenticationDetailsSource(captchaAuthenticationDetailsSource)
                    .loginPage("/login").failureUrl("/login?error").permitAll()
                .and()
                    .logout().logoutUrl("/logout").invalidateHttpSession(true).permitAll();
        // @formatter:on
        http.addFilterBefore(captchaCaptureFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(captchaDaoAuthenticationProvider);
    }

}
