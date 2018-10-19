package com.christian.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.christian.model.Person;
import com.christian.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Jon", 23));
		people.add(new Person("Mikel", 30));
		people.add(new Person("Eva", 43));
		people.add(new Person("Peter", 18));
		LOG.info("HELLO FROM SERVICE");
//		2018-10-19 14:55:30.399  INFO 50308 --- [nio-8080-exec-1] c.c.service.impl.ExampleServiceImpl      : HELLO FROM SERVICE
//		2018-10-19 14:55:30.709  INFO 50308 --- [nio-8080-exec-1] c.c.component.RequestTimeInterceptor     : --REQUEST URL: 'http://localhost:8080/example/exampleMAV' -- TOTAL TIME: '315'ms
		return people;
	}
}
