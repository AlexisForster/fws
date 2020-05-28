package com.forgottenwaysidestories.chapters;

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
import com.forgottenwaysidestories.stories.Story;

@CrossOrigin("*")
@RestController
public class ChapterController {

	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping("/topics/{topicId}/articles")
	public List<Chapter> getAllChaptersByStory(@PathVariable Long topicId) {
		return chapterService.getAllChaptersByStory(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/stories/{storyId}/chapters/{chapterId}")
	public Chapter getChapter(@PathVariable Long articleId, @PathVariable Long chapterId) {
		System.out.println("Controller Flowcheck");
		return chapterService.getChapter(articleId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/stories/{storyId}/chapters")
	public void addChapter(@RequestBody Chapter chapter, @PathVariable Long storyId, @PathVariable Long topicId) {
		chapter.setStory(new Story(storyId, "", "", "",topicId));
		chapterService.addChapter(chapter);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/stories/{storyId}/chapters")
	public void updateChapter(@RequestBody Chapter chapter, @PathVariable Long topicId, @PathVariable Long storyId) {
		chapter.setStory(new Story(storyId, "", "","", topicId));
		chapterService.updateChapter(chapter);		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/stories/{storyId}/chapters")
	public void deleteChapter(@PathVariable String articleId) {
		chapterService.deleteChapter(articleId);
	}
}
