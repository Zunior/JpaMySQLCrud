package myProjectMySql.repository;

import org.springframework.data.repository.CrudRepository;

import myProjectMySql.entity.Course;

public interface CourseRepository extends CrudRepository<Course, String>{
	
}
