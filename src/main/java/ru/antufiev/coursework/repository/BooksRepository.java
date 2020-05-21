package ru.antufiev.coursework.repository;

import org.springframework.data.repository.CrudRepository;
import ru.antufiev.coursework.entity.Books;

public interface BooksRepository extends CrudRepository<Books, Long> {
}
