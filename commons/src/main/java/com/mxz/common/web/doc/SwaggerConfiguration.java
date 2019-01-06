package com.mxz.common.web.doc;

import org.springframework.context.annotation.Bean;

import com.mxz.common.constants.APIVersionConstants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.catapultlearning.attendance.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Phone Repairing Inc Repairing RESTful APIs")
                .description("This is Phone Repairing RESTful APIs doucmentation")
                .termsOfServiceUrl("https://phonerepairing.com/")
                .version(APIVersionConstants.API_VERSION_1_0)
                .build();
    }

}
