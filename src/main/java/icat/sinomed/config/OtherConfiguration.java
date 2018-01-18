package icat.sinomed.config;

import ch.qos.logback.access.servlet.TeeFilter;
import icat.sinomed.filter.LoginFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.servlet.DispatcherType;

/**
 * Created by liucong on  16-4-5-005.
 */
@Configuration
public class OtherConfiguration {

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }


    @Bean
    public FilterRegistrationBean loginFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.addUrlPatterns("/wuyunliuqitu", "/wuyunliuqituAjax.jsp", "/api/wuyunliuqitu");
        final LoginFilter loginFilter = new LoginFilter();
        registration.setFilter(loginFilter);
        return registration;
    }

    @Bean
    public FilterRegistrationBean teeFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.addUrlPatterns("/*");
        final TeeFilter teeFilter = new TeeFilter();
        registration.setFilter(teeFilter);
        return registration;
    }

}
