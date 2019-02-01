package com.fangfa.projecttemplate.conf;
/**
 * @Auther 葛林
 * @Date 2019/1/30/030 15
 * @Remarks  跨域与静态资源配置
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


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

}