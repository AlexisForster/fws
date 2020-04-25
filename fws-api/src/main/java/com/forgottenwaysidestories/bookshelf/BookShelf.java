package com.forgottenwaysidestories.bookshelf;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookshelf")
public class BookShelf implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String code;
	private String name;

	public Long getId() {
		return id;
	}
	
	public BookShelf() {
		
	}
	
	public BookShelf(Long id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String title) {
		this.code = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String description) {
		this.name = description;
	}
}
