package org.grostarin.springboot.demorest.services;

import org.grostarin.springboot.demorest.domain.Book;
import org.grostarin.springboot.demorest.dto.BookSearch;
import org.grostarin.springboot.demorest.exceptions.BookIdMismatchException;
import org.grostarin.springboot.demorest.exceptions.BookNotFoundException;
import org.grostarin.springboot.demorest.exceptions.ForbiddenBookException;
import org.grostarin.springboot.demorest.repositories.BookRepository;
import org.grostarin.springboot.demorest.repositories.ForbiddenBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServices {    

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private ForbiddenBookRepository forbiddenBookRepository;
    
    public Iterable<Book> findAll(BookSearch bookSearchDTO) {
        if(bookSearchDTO!=null && StringUtils.hasText(bookSearchDTO.title())) {
            return bookRepository.findByTitle(bookSearchDTO.title());  
        }
        return bookRepository.findAll();
    }

    public Book findOne(long id) {
        return bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
    }

    public Book create(Book book) {
    	if (isBookForbidden(book)) {
            throw new ForbiddenBookException("The book is forbidden.");
        }

        return bookRepository.save(book);
    }

    public void delete(long id) {
        bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book, long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }
    
    private boolean isBookForbidden(Book book) {
        return forbiddenBookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor()).isPresent();
    }
}









