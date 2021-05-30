package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Spring MVC Application with Swagger: ").description(
                "Spring MVC documented with Swagger UI.")
                .license("Apache 2.0").licenseUrl("http://www.apache.org/license.LICENSE-2.0.html")
                .termsOfServiceUrl("").version("1.0.0").contact(new Contact("William Sanjaya","http://localhost:8080/demo_war_exploded/","william@mail.com")).build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo")).build().apiInfo(apiInfo());
    }
}
