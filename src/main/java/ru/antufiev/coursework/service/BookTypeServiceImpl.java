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
  public BookType addBookType(BookType bookType) {
    return repository.save(bookType);
  }

  @Override
  public BookType deleteBookType(long id) {
    Optional<BookType> optional = repository.findById(id);
    if (optional.isPresent()) {
      repository.deleteById(id);
      return optional.get();
    }
    throw new BookTypeNotFoundException("BookType with id = " + id + " doesnt exist");
  }

  @Override
  public List<BookType> updateBookType(BookType bookType) {
    Optional<BookType> optional = repository.findById(bookType.getBookTypeId());
    if (optional.isPresent()) {
      BookType bookTypeUpdate = optional.get();
      bookTypeUpdate.setName(bookType.getName());
      bookTypeUpdate.setCount(bookType.getCount());
      bookTypeUpdate.setDayCount(bookType.getDayCount());
      bookTypeUpdate.setFine(bookType.getFine());
      repository.save(bookTypeUpdate);
      return listBookType();
    }
    return listBookType();
  }
}
