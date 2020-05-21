package ru.antufiev.coursework.repository;

import org.springframework.data.repository.CrudRepository;
import ru.antufiev.coursework.entity.BookTypes;

public interface BooksTypesRepository extends CrudRepository<BookTypes, Long> {
}
