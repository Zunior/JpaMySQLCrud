package myProjectMySql.repository;

import org.springframework.data.repository.CrudRepository;

import myProjectMySql.entity.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{
	
}
