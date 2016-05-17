package me.superkoh.evpn.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by KOH on 16/5/17.
 */
@Configuration
@EnableSwagger2
@Profile("dev")
public class SpringFoxConfiguration {

    @Bean
    public Docket apidoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("me.superkoh.evpn.controller"))
                .build()
                .useDefaultResponseMessages(false);
    }
}
