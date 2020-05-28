package com.forgottenwaysidestories.chapters;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.forgottenwaysidestories.bookshelf.BookShelf;
import com.forgottenwaysidestories.stories.Story;

@Entity
@Table(name="chapter")
public class Chapter implements Serializable{
	
	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;

	@ManyToOne
	private Story story;
	
	public Long getId() {
		return id;
	}
	
	public Chapter() {
		
	}
	
	public Chapter(Long id, String title, String description, Long storyId, Long topicId) {
		super();
		this.id = id;
		this.title = title;
		this.story = new Story(storyId, "", "", "", topicId);
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void setStory(Story story) {
		this.story = story;
	}
	
	public Story getStory() {
		return story;
	}
}
