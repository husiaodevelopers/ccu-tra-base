package ccu.tra.ccutrabase.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * peter
 */
@Configuration
@EnableSwagger2 // 启用Swagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {// 创建API基本資訊
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ccu.tra.ccutrabase.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {// 这些資訊會在Swagger UI中顯示
        return new ApiInfoBuilder()
                .title("config APIs")// API 標題
                .description("config APIs")// API描述
                .version("1.0")// 版本號
                .build();
    }

}
