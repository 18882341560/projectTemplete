package com.fangfa.projecttemplate.conf;
/**
 * @Auther 葛林
 * @Date 2019/1/30/030 15
 * @Remarks  跨域与静态资源配置
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;


@Configuration
public class CorsConfig extends WebMvcConfigurationSupport {

    @Autowired
    private CustomProperties customProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置模板资源路径
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
        registry.addResourceHandler(customProperties.getSaveFilesFolder()+"/**").addResourceLocations("file:///"+customProperties.getSaveFilesFolder());
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    @Bean
    public HttpMessageConverter<String> responseBodyStringConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        return converter;
    }

    /**
     * 修改StringHttpMessageConverter默认配置,设置返回编码为utf-8
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(responseBodyStringConverter());
    }

}