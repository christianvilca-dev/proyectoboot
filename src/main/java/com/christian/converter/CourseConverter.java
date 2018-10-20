package com.christian.converter;

import org.springframework.stereotype.Component;

import com.christian.entity.Course;
import com.christian.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {

	// Transformar de un entity a un model
	public CourseModel entity2model(Course course) {
		CourseModel courseModel = new CourseModel();
		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getPrice());
		courseModel.setHours(course.getHours());
		return courseModel;
	}
	
	// Transformar de un model a un entity
	public Course model2entity(CourseModel courseModel) {
		Course course = new Course();
		course.setName(courseModel.getName());
		course.setDescription(courseModel.getDescription());
		course.setPrice(courseModel.getPrice());
		course.setHours(courseModel.getHours());
		return course;
	}
}
