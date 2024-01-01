package org.grostarin.springboot.demorest.tests;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.grostarin.springboot.demorest.domain.Book;
import org.grostarin.springboot.demorest.domain.ForbiddenBook;
import org.grostarin.springboot.demorest.exceptions.ForbiddenBookException;
import org.grostarin.springboot.demorest.repositories.ForbiddenBookRepository;
import org.grostarin.springboot.demorest.services.BookServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
public class BookServiceTests {
    @Autowired
    private BookServices bookService;
    
    @Autowired
    private ForbiddenBookRepository forbiddenBookRepository;
    
    @Test
    public void testCreationNoAttributes() {
        Book toCreate = new Book();
        assertThatExceptionOfType(DataIntegrityViolationException.class).isThrownBy( () -> bookService.create(toCreate));
    }
    
    @Test
    public void testCreationForbiddenBook() {
        ForbiddenBook forbiddenBook = new ForbiddenBook();
        forbiddenBook.setId(1);
        forbiddenBook.setTitle("ForbiddenTitle");
        forbiddenBook.setAuthor("ForbiddenAuthor");

        forbiddenBookRepository.save(forbiddenBook);

        Book forbiddenBookToCreate = new Book();
        forbiddenBookToCreate.setTitle("ForbiddenTitle");
        forbiddenBookToCreate.setAuthor("ForbiddenAuthor");

        assertThatExceptionOfType(ForbiddenBookException.class)
            .isThrownBy(() -> bookService.create(forbiddenBookToCreate));
    }
       
}