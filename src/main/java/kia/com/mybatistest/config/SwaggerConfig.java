package kia.com.mybatistest.config;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@OpenAPIDefinition(
        info = @Info(
                title = "board project API 명세서",
                description = "회원 관련 API",
                version = "v1",
                contact = @Contact(
                        name = "PARKSUNGJUN",
                        email = "tjdwns4537@kia.com"
                )
        )
)
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30) // 3.0 문서버전으로 세팅
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mybatistest.member.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger 3.0 Api Sample")
                .description("This is Sample")
                .version("1.0")
                .build();
    }

//    @Bean
//    public Docket api2() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("board")
//                .consumes(getConsumeContentTypes())
//                .produces(getProduceContentTypes())
//                .apiInfo(getApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.mybatistest.board.controller"))
//                .paths(PathSelectors.ant("/**"))
//                .build();
//    }

//    private Set<String> getConsumeContentTypes() {
//        Set<String> consumes = new HashSet<>();
//        consumes.add("application/json;charset=UTF-8");
//        consumes.add("application/x-www-form-urlencoded");
//        return consumes;
//    }
//
//    private Set<String> getProduceContentTypes() {
//        Set<String> produces = new HashSet<>();
//        produces.add("application/json;charset=UTF-8");
//        return produces;
//    }
//
//    private ApiInfo getApiInfo() {
//        return new ApiInfoBuilder()
//                .title("API")
//                .description("REST API")
//                .contact(new Contact("[Board Project Swagger]", "https://github.com/tjdwns4537", "tjdwns4537@naver.com"))
//                .version("1.0")
//                .build();
//    }
}
