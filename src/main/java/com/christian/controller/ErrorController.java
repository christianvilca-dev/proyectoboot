package com.christian.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Para encargarse de la captura de errores
public class ErrorController {
	
	public static final String ISE_VIEW = "error/500";
	
	@ExceptionHandler(Exception.class) // en caso de error 500
	public String showInternarServerError() {
		return ISE_VIEW;
	}

}
