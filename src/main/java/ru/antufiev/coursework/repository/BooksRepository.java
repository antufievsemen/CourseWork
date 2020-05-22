package ru.antufiev.coursework.repository;

import org.springframework.data.repository.CrudRepository;
import ru.antufiev.coursework.entity.Book;

public interface BooksRepository extends CrudRepository<Book, Long> {
}
