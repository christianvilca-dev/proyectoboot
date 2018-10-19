package com.christian.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent") // Para que spring lo guarde en memoria cuando arranque la aplicacion
public class ExampleComponent {
	
	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);

	public void sayHello() {
		LOG.info("HELLO FROM EXAMPLE COMPONENT");
	}
}
