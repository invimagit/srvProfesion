package co.com.invima.maestro.service.srvProfesion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
@EntityScan({"co.com.invima.maestro.modeloTransversal"})
public class SrvProfesionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrvProfesionApplication.class, args);
    }


    /*Permite solucionar las politicas de CORS (Acceder sin inconvenientes a todos los métodos)
    en el Front */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
    }

    /**
     * @return Docket
     * @author RScalante Swagger Doc
     */
    @Bean
    public Docket apiDocket() {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("co.com.invima.maestro.service.srvProfesion"))
                .paths(PathSelectors.any()).build().apiInfo(getApiInfo());

    }

    /**
     * @return ApiInfo
     * @author RScalante Aplication Info
     */
    private ApiInfo getApiInfo() {
        return new ApiInfo("Profesión API", "This API provides a layer to manage entity Profesión ", "1.0.0", "Rest",
                new Contact("SmartBit", "http://smartBit.com/", "smartBit@email.com"), "2019 - SmartBit",
                "http://smartBit.com/", Collections.emptyList());
    }

}
