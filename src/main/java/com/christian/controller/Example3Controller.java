package com.christian.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.christian.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class); // Se pone la clase responsable en el getlog()

	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	// Primera forma
	/*@GetMapping("/")
	public String redirect() {
		return "redirect:/example3/showform";
	}*/
	
	@GetMapping("/")
	public RedirectView redirect() {
	    return new RedirectView("/example3/showform");
	}
	
	// Muestra el formulario
	@GetMapping("/showform")
	public String showForm(Model model) {
		// Niveles de las trazas
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE"); // No se muestra, pero si se arranca en modo DEBUG si se muestra
//		FECHA	   HORA			NIVEL ID		HILO			  CLASE RESPONSABLE							 MENSAJE
//		2018-10-19 13:29:17.133  INFO 53748 --- [nio-8080-exec-1] c.c.controller.Example3Controller        : INFO TRACE
//		2018-10-19 13:29:17.134  WARN 53748 --- [nio-8080-exec-1] c.c.controller.Example3Controller        : WARNING TRACE
//		2018-10-19 13:29:17.134 ERROR 53748 --- [nio-8080-exec-1] c.c.controller.Example3Controller        : ERROR TRACE
		
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	// Envia la peticion POST
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person) {
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("person", person);
		return mav;
	}
}
