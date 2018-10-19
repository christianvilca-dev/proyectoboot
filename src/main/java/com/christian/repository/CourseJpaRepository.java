package com.christian.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.christian.entity.Course;

// Aunque automaticamente ya existen algunos metodos
// Esta intergace nos permite crear metodos personalizadosque siguen una logica que JPA Repository acepte
@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable>{

	// Nos hace una query automaticamente y busca por precio
	public abstract Course findByPrice(int price);
	
	public abstract Course findbyPriceAndName(int price, String name);
	
	public abstract List<Course> findByNameOrderByHours(String name);
	
	public abstract Course findByNameOrPrice(String name, int price);
}
