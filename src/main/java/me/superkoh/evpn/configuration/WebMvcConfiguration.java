package me.superkoh.evpn.configuration;

import me.superkoh.evpn.controller.advice.BeforeActionInterceptor;
import me.superkoh.evpn.controller.advice.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by KOH on 16/5/9.
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (env.acceptsProfiles("prod")) {
            registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/*").excludePathPatterns("/notify.php");
        }
        registry.addInterceptor(new BeforeActionInterceptor()).addPathPatterns("/*");
        super.addInterceptors(registry);
    }
}
