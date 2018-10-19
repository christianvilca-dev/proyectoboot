package com.christian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // Se indica que es un bean "@component" y es encargado de la capa presentacion es el hijo "@controller"
@RequestMapping("/example")// Indica el path entrada por esta clase
public class ExampleController {
	
	public static final String EXAMPLE_VIEW="example";

	// Primera forma -> Para redirecciones, no hay insertar datos o se insertan muy pocos
	//@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		model.addAttribute("name", "Jon");
		return EXAMPLE_VIEW; // la vista a retornar y no es necesario el .html
	}
	
	// Segunda forma --> Para insertar muchos datos
	//@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav= new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("name", "Mikel");
		return mav;
	}
}
