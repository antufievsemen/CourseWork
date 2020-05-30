package ru.antufiev.coursework.service;

import ru.antufiev.coursework.entity.BookType;

import java.util.List;

public interface BookTypeService {
  List<BookType> listBookType();
  BookType findBookTypeById(long id);
  BookType addBookType(BookType bookType);
  BookType deleteBookType(long id);
  List<BookType> updateBookType(BookType bookType);
}
