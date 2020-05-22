package ru.antufiev.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.antufiev.coursework.entity.BookType;
import ru.antufiev.coursework.exception.BookTypeNotFoundException;
import ru.antufiev.coursework.repository.BooksTypesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookTypeServiceImpl implements BookTypeService {

  @Autowired
  private BooksTypesRepository repository;

  @Override
  public List<BookType> listBookType() {
    return (List<BookType>) repository.findAll();
  }

  @Override
  public BookType findBookTypeById(long id) {
    Optional<BookType> optional = repository.findById(id);
    if (optional.isPresent()) {
      return optional.get();
    }
    throw new BookTypeNotFoundException("BookType with id = " + id + " doesnt exist");
  }

  @Override
  public List<BookType> listBookTypesLowFine(long fine) {
    List<BookType> listBookType = (List<BookType>) repository.findAll();
    List<BookType> listResult = new ArrayList<>();
    for (BookType bookType : listBookType) {
      if (bookType.getFine() <= fine) {
        listResult.add(bookType);
      }
    }
    return listResult;
  }

  @Override
  public boolean isExist(BookType bookType) {
    List<BookType> listBookType = (List<BookType>) repository.findAll();
    for (BookType type : listBookType) {
      if (bookType.isEquals(type)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public BookType addBookType(BookType bookType) {
    return repository.save(bookType);
  }
}