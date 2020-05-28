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
	
	
	public List<Story> getStoriesByBookshelf(Long bookshelfId) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();		
		List<Story> stories = new ArrayList<>();
		storyRepository.findByBookshelfId(bookshelfId)
				.forEach(stories::add);
		return stories;
	}

	public Story getStory(Long storyId) {
		return storyRepository.findById(storyId).get();
	}
	
	public void addStory(Story story) {
		storyRepository.save(story);
	}

	public void updateStory(Story story) {
		storyRepository.save(story);
	}

	public void deleteStory(String storyId) {
		storyRepository.deleteById(new Long(storyId));
	}
}
