package br.com.casacodigo.api.swagger;

import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration implements WebMvcConfigurer {
    Predicate<String> apiUrl = PathSelectors.ant("/api/**");
    Predicate<RequestHandler> basPackage = RequestHandlerSelectors.basePackage("br.com.codehouse.api");
   
    @Bean
    public Docket api() {
	 return new Docket( DocumentationType.SWAGGER_2)
		 .select()
		 .apis(basPackage).paths(apiUrl)
		 .build().apiInfo(metaData());
    }
    
    private ApiInfo metaData() {
	    return new ApiInfoBuilder()
	        .title("Code House API")
	        .description(" API de livros baseados na casa do codigo.")
	        .version("1.0.0")
	        .license("Apache License Version 2.0")
	        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	        .build();
	  }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("swagger-ui.html")
          .addResourceLocations("classpath:/META-INF/resources/");

      registry.addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
