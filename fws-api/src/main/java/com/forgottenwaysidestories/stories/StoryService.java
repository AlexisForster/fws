package com.forgottenwaysidestories.stories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StoryService {
	
	@Autowired
	private StoryRepository storyRepository;
	
	
	public List<Story> getStoriesByTopic(Long topicId) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();		
		List<Story> articles = new ArrayList<>();
		storyRepository.findByTopicId(topicId)
				.forEach(articles::add);
		return articles;
	}

	public Story getStory(Long storyId) {
		return storyRepository.findById(storyId).get();
	}
	
	public void addStory(Story course) {
		storyRepository.save(course);
	}

	public void updateStory(Story course) {
		storyRepository.save(course);
	}

	public void deleteStory(String id) {
		storyRepository.deleteById(new Long(id));
	}
}
