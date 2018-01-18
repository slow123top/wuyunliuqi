package icat.sinomed;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class SinomedApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SinomedApplication.class);
    }


    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(SinomedApplication.class).run(args);
    }

}
