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
	private String summary;
	private String imageLink;

	@ManyToOne
	private BookShelf bookshelf;
	
	public Long getId() {
		return id;
	}
	
	public Story() {
		
	}
	
	public Story(Long id, String title, String summary, String imageLink, Long bookshelfId) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.imageLink = imageLink;
		this.bookshelf = new BookShelf(bookshelfId, "", "");
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String description) {
		this.summary = description;
	}
	
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public void setBookshelf(BookShelf topic) {
		this.bookshelf = topic;
	}
	
	public BookShelf getBookshelf() {
		return bookshelf;
	}
}
