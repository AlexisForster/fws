package com.forgottenwaysidestories.bookshelf;

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

@CrossOrigin("${access.cross-origin}")
@RestController
public class BookShelfController {

	@Autowired
	private BookShelfService topicService;
	
	@RequestMapping("/bookshelf")
	public List<BookShelf> getAllTopics() {
		return topicService.getAllBookshelf();
	}
	
	@RequestMapping("/bookshelf/{id}")
	public BookShelf getBookShelf(@PathVariable String id) {
		return topicService.getBookShelf(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/bookshelf")
	public void addBookShelf(@RequestBody BookShelf topic) {
		topicService.addBookShelf(topic);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/bookshelf/{id}")
	public void updateBookShelf(@RequestBody BookShelf topic, @PathVariable String id) {
		topicService.updateBookShelf(id, topic);		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/bookshelf/{id}")
	public void deleteBookShelf(@PathVariable String id) {
		topicService.deleteBookshelf(id);
	}

}
