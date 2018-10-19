package com.christian.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter { // Por cada peticion que se haga entre por esta clase en los diferentes metods que se sobreescriba
	
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	@Override
	// Primero
	// Se ejecuta antes de entrar en el metodo del controlador
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	@Override
	// Segundo
	// Se ejecuta justo antes de mostrar (del return) la vista en el navegador
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("--REQUEST URL: '" + request.getRequestURL().toString() + "' -- TOTAL TIME: '" + (System.currentTimeMillis() - startTime) + "'ms");
//		2018-10-19 14:41:44.666  INFO 16480 --- [nio-8080-exec-4] c.c.component.RequestTimeInterceptor     : --REQUEST URL: 'http://localhost:8080/example/exampleString' -- TOTAL TIME: '3'ms
//		2018-10-19 14:42:04.068  INFO 16480 --- [nio-8080-exec-7] c.c.component.RequestTimeInterceptor     : --REQUEST URL: 'http://localhost:8080/example/exampleMAV' -- TOTAL TIME: '3'ms
//		2018-10-19 14:42:30.079  INFO 16480 --- [nio-8080-exec-9] c.c.component.RequestTimeInterceptor     : --REQUEST URL: 'http://localhost:8080/example3/showform' -- TOTAL TIME: '24'ms
	}
}
