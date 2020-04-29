package myProjectMySql.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myProjectMySql.entity.Topic;
import myProjectMySql.repository.TopicRepository;
import myProjectMySql.service.GenericService;

@Service
public class TopicServiceImpl implements GenericService<Topic> {

	@Autowired
	private TopicRepository topicRepository;

	@Override
	public List<Topic> getAll() {
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	@Override
	public Topic get(String id) {
		Optional<Topic> topic = topicRepository.findById(id);
		if (topic.isPresent())
			return topic.get();
		else
			return null;
	}

	@Override
	public void add(Topic t) {
		topicRepository.save(t);
	}

	@Override
	public void update(Topic t) {
		topicRepository.save(t);

	}

	@Override
	public void delete(String id) {
		topicRepository.deleteById(id);
	}

}
