package com.forgottenwaysidestories.bookshelf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("topicRepository")
public interface BookShelfRepository extends JpaRepository<BookShelf, Long >{
	
}
