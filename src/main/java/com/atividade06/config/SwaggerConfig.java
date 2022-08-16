package com.atividade06.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

public static final String BASE_PATH = "com.atividade06.controller";
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PATH)).build()
				.apiInfo(metaData()).protocols(protocols());

	}

	private Set<String> protocols() {
		Set<String> protocols = new HashSet<>(1);
		protocols.add("http");
		return protocols;
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Sistemas de Banco de Dados - Atividade 06")
				.description("Sistemas de Banco de Dados - Atividade 06")
				.version("v1")
				.license("Joao Jungles - Todos os Direitos Reservados")
				.licenseUrl("").build();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}