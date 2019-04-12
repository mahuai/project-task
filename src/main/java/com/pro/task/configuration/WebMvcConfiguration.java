package com.pro.task.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Auther: admin
 * @Date: 2019/4/11 10:12
 * @Description: 资源配置
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**","/templates/**").addResourceLocations("classpath:/static/","classpath:/templates/");
        super.addResourceHandlers(registry);
    }
}
