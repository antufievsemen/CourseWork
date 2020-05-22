package ru.antufiev.coursework.repository;

import org.springframework.data.repository.CrudRepository;
import ru.antufiev.coursework.entity.BookType;

public interface BooksTypesRepository extends CrudRepository<BookType, Long> {
}
