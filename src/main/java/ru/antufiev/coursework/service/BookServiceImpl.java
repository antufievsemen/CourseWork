package ru.antufiev.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;
import ru.antufiev.coursework.entity.Book;
import ru.antufiev.coursework.exception.BookNotFoundException;
import ru.antufiev.coursework.repository.BooksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

  @Autowired
  private BooksRepository repository;

  @Override
  public List<Book> listBooks() {
    return (List<Book>) repository.findAll();
  }

  @Override
  public Book findBookById(long id) {
    Optional<Book> optionalBook = repository.findById(id);
    if (optionalBook.isPresent()) {
      return optionalBook.get();
    }
    throw new BookNotFoundException("Book with id = " + id + "doesnt exist");
  }

  @Override
  public boolean isExist(Book book) {
    List<Book> listBook = (List<Book>) repository.findAll();
    for (Book element : listBook) {
      if (book.isEquals(element)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Book addBook(Book book) {
    return repository.save(book);
  }

}
