package com.christian.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.christian.entity.Course;
import com.christian.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("querySQLExampleRepo")
public class QueryDSLExampleRepo {
	// La clase no pertenece a los recursos del proyecto 
	// para ello en consola ->mvn eclipse:eclipse
	// Lo que hace recursos que se han autogenerado se ponga a los recursos de la aplicacion y que no sean externos
	// por lo que ya podremos importarlos
	private QCourse qCourse = QCourse.course; 
	
	//	EntityManager 
	//	Objeto que se encarga de gestionar las entidades de la persistencia 
	//	de la aplicacion, el cual se encuentra en el contexto de la persistencia de la aplicacion
	@PersistenceContext
	private EntityManager em;
	
	// Todos los metodos a los que se vaya a usar una consulta con QueryDSL
	// tenemos que usar la clase JPAQQuery
	public Course find(boolean exit) {
		JPAQuery<Course> query = new JPAQuery<Course>(em); // Nos pide EntityManager
		
		// Estructura del JPAQuery
		Course course = new Course();
		
		// Ejemplo 1
		course = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne(); //fetchOne() -> para obtener el dato
		
		// Ejemplo 2
		course = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		
		// Ejemplo 3
		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
		
		// Ejemplo 4
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		if (exit) {
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
		
		// El objeto que admite el where es el predicate
		course = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(predicateBuilder).fetchOne();
		
		return course;
	}
}
