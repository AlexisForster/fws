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

@CrossOrigin("${access.cross-origin}")
@RestController
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	@RequestMapping("/bookshelf/{bookshelfId}/stories")
	public List<Story> getAllStoriesByTopic(@PathVariable Long bookshelfId) {
		return storyService.getStoriesByBookshelf(bookshelfId);
	}
	
	@RequestMapping("/bookshelf/{bookshelfId}/stories/{storyId}")
	public Story getStory(@PathVariable Long storyId) {
		System.out.println("Controller Flowcheck");
		return storyService.getStory(storyId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/bookshelf/{bookshelfId}/stories")
	public void addStory(@RequestBody Story story, @PathVariable Long bookshelfId) {
		story.setBookshelf(new BookShelf(bookshelfId, "", ""));
		storyService.addStory(story);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/bookshelf/{bookshelfId}/stories/{storyId}")
	public void updateStory(@RequestBody Story story, @PathVariable Long bookshelfId, @PathVariable Long storyId) {
		story.setBookshelf(new BookShelf(bookshelfId, "", ""));
		storyService.updateStory(story);		
	}
	
	public void deleteArticle(@PathVariable String storyId) {
		storyService.deleteStory(storyId);
	}
}
