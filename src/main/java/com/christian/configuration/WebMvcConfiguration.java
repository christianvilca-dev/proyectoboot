package com.christian.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.christian.component.RequestTimeInterceptor;

/*
 * A veces no nos permite String Boot configurar lo que deseamos en el "application.yml"
 * y tenemos que configurar en una clase java y antes se hacia en xml
 * ****************************************************************************
 * clase WebMvcConfigurerAdapter está deprecated (Obsoleto).

	implementar la interfaz WebMvcConfigurer, y sobrescribir el método addInterceptors() 
	de la misma forma que con la clase WebMvcConfigurerAdapter.
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestTimeInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimeInterceptor);
	}
}
