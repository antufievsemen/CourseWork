package ru.antufiev.coursework.service;

import ru.antufiev.coursework.entity.BookType;

import java.util.List;

public interface BookTypeService {
  List<BookType> listBookType();
  BookType findBookTypeById(long id);
  List<BookType> listBookTypesLowFine(long fine);
  boolean isExist(BookType bookType);
  BookType addBookType(BookType bookType);
}
