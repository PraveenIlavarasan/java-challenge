package jp.co.axa.api.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String TAG_1 = "This controller is for Employee data operation";

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build()
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(basicAuthScheme()));
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(Arrays.asList(basicAuthReference()))
				.forPaths(PathSelectors.ant("/api/**"))
				.build();
	}

	private SecurityScheme basicAuthScheme() {
		return new BasicAuth("basicAuth");
	}

	private SecurityReference basicAuthReference() {
		return new SecurityReference("basicAuth", new AuthorizationScope[0]);
	};

}