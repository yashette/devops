package org.grostarin.springboot.demorest.repositories;

import java.util.Optional;
import org.grostarin.springboot.demorest.domain.ForbiddenBook;
import org.springframework.data.repository.CrudRepository;

public interface ForbiddenBookRepository extends CrudRepository<ForbiddenBook, Long> {
	Optional<ForbiddenBook> findByTitleAndAuthor(String title, String author);
}
