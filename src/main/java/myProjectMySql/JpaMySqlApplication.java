package myProjectMySql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import myProjectMySql.entity.Course;
import myProjectMySql.entity.Topic;
import myProjectMySql.service.GenericService;

@SpringBootApplication
public class JpaMySqlApplication {
	
	@Autowired
	private static GenericService<Topic> topicService;
	@Autowired
	private static GenericService<Course> courseService;

	public JpaMySqlApplication(
			GenericService<Topic> topicService, 
			GenericService<Course> courseService) {
		JpaMySqlApplication.topicService = topicService;
		JpaMySqlApplication.courseService = courseService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JpaMySqlApplication.class, args);
		
		topicService.add(new Topic("java", "Java Core", "Java Core Description"));
		courseService.add(new Course("java-streams", "Java Streams", "Java Streams Description", "java"));
		
		Topic topic = topicService.get("java");
		System.out.println(topic);
		List<Course> courses =courseService.getAll();
		for (Course course : courses) {
			if(course.getTopic().getId().equals(topic.getId()))
				System.out.println(course);
		}
		
	}

}
