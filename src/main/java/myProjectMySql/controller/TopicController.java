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

import myProjectMySql.entity.Topic;
import myProjectMySql.service.GenericService;

@RestController
@RequestMapping(value = "/topics")
public class TopicController {
	
	@Autowired
	private GenericService<Topic> service;

	@GetMapping
	public List<Topic> getAllTopics() {
		return service.getAll();
	}
	
	@GetMapping(value = "{id}")
	public Topic getTopic(@PathVariable String id) {
		return service.get(id);
	}
	
	@PostMapping(consumes = "application/json")
	public void addTopic(@RequestBody Topic topic) {
		service.add(topic);;
	}
	
	@PutMapping(value = "{id}", consumes = "application/json")
	public void updateTopic(@RequestBody Topic topic) {
		service.update(topic);;
	}
	
	@DeleteMapping("{id}")
	public void deleteTopic(@PathVariable String id) {
		service.delete(id);;
	}
	
}
