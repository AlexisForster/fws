package com.forgottenwaysidestories.chapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChapterService {
	
	@Autowired
	private ChapterRepository chapterRepository;
	
	
	public List<Chapter> getAllChaptersByStory(Long topicId) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();		
		List<Chapter> articles = new ArrayList<>();
		chapterRepository.findByStoryId(topicId)
				.forEach(articles::add);
		return articles;
	}

	public Chapter getChapter(Long articleId) {
		return chapterRepository.findById(articleId).get();
	}
	
	public void addChapter(Chapter course) {
		chapterRepository.save(course);
	}

	public void updateChapter(Chapter course) {
		chapterRepository.save(course);
	}

	public void deleteChapter(String id) {
		chapterRepository.deleteById(new Long(id));
	}
}
