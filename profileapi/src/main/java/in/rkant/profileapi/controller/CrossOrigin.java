package in.rkant.profileapi.controller;
/*
    @author::Ravikant
    @author-id::rkant
    @date:: Dec 10 IST 2019
    @version::1.0.0
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOrigin {

    @Bean
    public WebMvcConfigurer crossConfigure(){
        return new CrossOriginConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET","POST", "PUT", "DELETE").allowedOrigins("*").allowedHeaders("*");
            }
        };
    }
}
