package com.fangfa.projecttemplate.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 访问http://localhost:8080/swagger-ui.html
 * @Auther 葛林
 * @Date 2019/2/1/001 11
 * @Remarks  接口文档配置
 */
@Configuration
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fangfa.projecttemplate.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("系统模板api")
                .description("如有疑问，请拨打110")
                .termsOfServiceUrl("http://localhost:8081/swagger-ui.html")
                .version("1.0")
                .build();
    }
}
