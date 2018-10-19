package com.christian.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.christian.component.ExampleComponent;
import com.christian.model.Person;
import com.christian.service.ExampleService;

@Controller // Se indica que es un bean "@component" y es encargado de la capa presentacion es el hijo "@controller"
@RequestMapping("/example")// Indica el path entrada por esta clase
public class ExampleController {
	
	public static final String EXAMPLE_VIEW="example";
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	// Injectamos el componente creado
	@Autowired
	@Qualifier("exampleComponent") // Especifica el nombre del bean que esta guardado en memoria
	private ExampleComponent exampleComponent; // No crea el objeto mendiante new
		

	// Primera forma -> Para redirecciones, no hay insertar datos o se insertan muy pocos
	//@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();
//		2018-10-19 13:59:22.373  INFO 36332 --- [nio-8080-exec-1] c.christian.component.ExampleComponent   : HELLO FROM EXAMPLE COMPONENT
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW; // la vista a retornar y no es necesario el .html
	}
	
	// Segunda forma --> Para insertar muchos datos
	//@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav= new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", exampleService.getListPeople());
		return mav;
	}
	
	/*private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Jon", 23));
		people.add(new Person("Mikel", 30));
		people.add(new Person("Eva", 43));
		people.add(new Person("Peter", 18));
		return people;
	}*/
}
