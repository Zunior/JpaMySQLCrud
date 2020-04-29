package myProjectMySql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myProjectMySql.entity.Course;
import myProjectMySql.service.GenericService;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {
	
	@Autowired
	private GenericService<Course> service;

	@GetMapping
	public List<Course> getAllCourses() {
		return service.getAll();
	}
	
	@GetMapping(value = "{id}")
	public Course getCourse(@PathVariable String id) {
		return service.get(id);
	}
	
	@PostMapping(consumes = "application/json")
	public void addCourse(@RequestBody Course course) {
		service.add(course);;
	}
	
	@PutMapping(value = "{id}", consumes = "application/json")
	public void updateCourse(@RequestBody Course course) {
		service.update(course);;
	}
	
	@DeleteMapping("{id}")
	public void deleteCourse(@PathVariable String id) {
		service.delete(id);;
	}
	
}
