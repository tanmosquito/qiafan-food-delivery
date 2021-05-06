package com.orangeven.qiafan.configuration.spring;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.orangeven.qiafan.configuration.spring.formatter.GenderFormatter;
import com.orangeven.qiafan.configuration.spring.formatter.TimeFormatter;

import net.bytebuddy.utility.RandomString;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.orangeven.qiafan.app",
        "com.orangeven.qiafan.configuration"
})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new GenderFormatter());
        registry.addFormatter(new TimeFormatter());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
    	
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/*.html")
    	.addResourceLocations("classpath:/webapp/public/");
    	registry.addResourceHandler("/js/**")
    	.addResourceLocations("classpath:/webapp/public/js/");
    	registry.addResourceHandler("/css/**")
    	.addResourceLocations("classpath:/webapp/public/css/");
    	registry.addResourceHandler("/favicon.ico")
    	.addResourceLocations("classpath:/webapp/public/favicon.ico");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }


}
