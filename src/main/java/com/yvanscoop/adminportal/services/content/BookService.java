package com.yvanscoop.adminportal.services.content;

import com.yvanscoop.adminportal.entities.content.Book;
import com.yvanscoop.adminportal.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book getBook(Long id){
        return bookRepository.getOne(id);
    }


    public void removeOne(Long idBook) {
        bookRepository.deleteById(idBook);
    }
}
