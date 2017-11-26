package org.mufuku.dockercluster.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@Configuration
@EnableRedisHttpSession
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/todoList/items");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/todoList/").setViewName("redirect:/todoList/items");
    }

}
