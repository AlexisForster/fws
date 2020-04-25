package com.forgottenwaysidestories.bookshelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookShelfService {
	
	@Autowired
	private BookShelfRepository bookShelfRepository;
	
	public List<BookShelf> getAllBookshelf(){
		List<BookShelf> bookshelf = new ArrayList<>();
		bookShelfRepository.findAll()
		.forEach(bookshelf::add);
		return bookshelf;
	}
	
	public BookShelf getBookShelf(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();		
		return bookShelfRepository.findById(new Long(id)).get();
	}

	public void addBookShelf(BookShelf topic) {
		bookShelfRepository.save(topic);
	}

	public void updateBookShelf(String id, BookShelf topic) {
		bookShelfRepository.save(topic);
	}

	public void deleteBookshelf(String id) {
		bookShelfRepository.deleteById(new Long(id));
	}
}
