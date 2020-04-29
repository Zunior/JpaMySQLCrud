package myProjectMySql.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myProjectMySql.entity.Course;
import myProjectMySql.entity.Topic;
import myProjectMySql.repository.CourseRepository;
import myProjectMySql.repository.TopicRepository;
import myProjectMySql.service.GenericService;

@Service
public class CourseServiceImpl implements GenericService<Course> {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getAll() {
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	@Override
	public Course get(String id) {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent())
			return course.get();
		else
			return null;
	}

	@Override
	public void add(Course c) {
		courseRepository.save(c);
	}

	@Override
	public void update(Course c) {
		courseRepository.save(c);

	}

	@Override
	public void delete(String id) {
		courseRepository.deleteById(id);
	}

}
