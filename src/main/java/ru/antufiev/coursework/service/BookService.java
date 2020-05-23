package ru.antufiev.coursework.service;

import ru.antufiev.coursework.entity.Book;

import java.util.List;

public interface BookService {
  List<Book> listBooks();
  Book findBookById(long id);
  boolean isExist(Book book);
  Book addBook(Book book);
  Book deleteBook(long id);
  List<Book> updateBook(Book book);
}
