 package com.forgottenwaysidestories.chapters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("chapterRepository")
public interface ChapterRepository extends JpaRepository<Chapter, Long >{
	
	public List<Chapter> findByStoryId(Long storyId);
	
}
