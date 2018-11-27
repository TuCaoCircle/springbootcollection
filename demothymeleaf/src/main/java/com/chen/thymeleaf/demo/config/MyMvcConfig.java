package com.chen.thymeleaf.demo.config;

import com.chen.thymeleaf.demo.component.MyHandlerInterceptor;
import com.chen.thymeleaf.demo.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
         registry.addViewController("/login").setViewName("index");
         registry.addViewController("/").setViewName("index");
         registry.addViewController("/main").setViewName("dashboard");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/asserts/*").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/login","/","/user/login");
    }

    //方法名是localeResolver 如果写错了 自己的MyLocaleResolver 无法把改变的内容真正注入到容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
