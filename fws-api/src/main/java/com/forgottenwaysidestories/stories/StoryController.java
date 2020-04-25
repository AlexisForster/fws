package com.forgottenwaysidestories.stories;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.forgottenwaysidestories.bookshelf.BookShelf;

@CrossOrigin("*")
@RestController
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	@RequestMapping("/topics/{topicId}/stories")
	public List<Story> getAllStoriesByTopic(@PathVariable Long topicId) {
		return storyService.getStoriesByTopic(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/stories/{storyId}")
	public Story getStory(@PathVariable Long storyId) {
		System.out.println("Controller Flowcheck");
		return storyService.getStory(storyId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/stories")
	public void addStory(@RequestBody Story story, @PathVariable Long topicId) {
		story.setTopic(new BookShelf(topicId, "", ""));
		storyService.addStory(story);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/stories/{storyId}")
	public void updateStory(@RequestBody Story story, @PathVariable Long topicId, @PathVariable Long storyId) {
		story.setTopic(new BookShelf(topicId, "", ""));
		storyService.updateStory(story);		
	}
	
	public void deleteArticle(@PathVariable String storyId) {
		storyService.deleteStory(storyId);
	}
}
