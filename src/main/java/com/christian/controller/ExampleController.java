package com.christian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // Se indica que es un bean "@component" y es encargado de la capa presentacion es el hijo "@controller"
@RequestMapping("/example")// Indica el path entrada por esta clase
public class ExampleController {
	
	public static final String EXAMPLE_VIEW="example";

	// Primera forma
	//@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString() {
		return EXAMPLE_VIEW; // la vista a retornar y no es necesario el .html
	}
	
	// Segunda forma
	//@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		return new ModelAndView(EXAMPLE_VIEW);
	}
}
