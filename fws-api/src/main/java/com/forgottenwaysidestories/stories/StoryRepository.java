 package com.forgottenwaysidestories.stories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("storyRepository")
public interface StoryRepository extends JpaRepository<Story, Long >{
	
	public List<Story> findByTopicId(Long topicId);
	
}
