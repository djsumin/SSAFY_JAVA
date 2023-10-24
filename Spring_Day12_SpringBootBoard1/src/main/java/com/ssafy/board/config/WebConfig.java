package com.ssafy.board.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	@Value("${spring.mvc.view.prefix}")
	private String prefix;
	@Value("${spring.mvc.view.suffix}")
	private String suffix;
	
	//추후에 관심이 있다면 FileDownload도 처리해보자.
	@Bean
	public ViewResolver InternalResourceViewResolver () {
		InternalResourceViewResolver resolver = new org.springframework.web.servlet.view.InternalResourceViewResolver();
		resolver.setPrefix(prefix);
		resolver.setSuffix(suffix);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

	
	//등록할 인터셉터가 있다면
	//필드를 통해 의존성을 주입받고 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//등록하면 된다.
	}
	
}
