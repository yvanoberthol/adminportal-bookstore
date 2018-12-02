package com.yvanscoop.adminportal.repositories;

import com.yvanscoop.adminportal.entities.content.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
