package com.christian.controller;

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
		model.addAttribute("person", new Person());
		int i = 6/0;
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
