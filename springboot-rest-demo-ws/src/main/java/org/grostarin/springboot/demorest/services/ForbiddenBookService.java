package org.grostarin.springboot.demorest.services;


import org.grostarin.springboot.demorest.domain.ForbiddenBook;
import org.grostarin.springboot.demorest.repositories.ForbiddenBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForbiddenBookService {

    @Autowired
    private ForbiddenBookRepository forbiddenBookRepository;

    public void addForbiddenBook(ForbiddenBook forbiddenBook) {
        forbiddenBookRepository.save(forbiddenBook);
    }

}
