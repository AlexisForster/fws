package com.forgottenwaysidestories.stories;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.forgottenwaysidestories.bookshelf.BookShelf;

@Entity
@Table(name="story")
public class Story implements Serializable{
	
	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String description;

	@ManyToOne
	private BookShelf topic;
	
	public Long getId() {
		return id;
	}
	
	public Story() {
		
	}
	
	public Story(Long id, String title, String description, Long topicId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.topic = new BookShelf(topicId, "", "");
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public void setTopic(BookShelf topic) {
		this.topic = topic;
	}
	
	public BookShelf getTopic() {
		return topic;
	}
}
