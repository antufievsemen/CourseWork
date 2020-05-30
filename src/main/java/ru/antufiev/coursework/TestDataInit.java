package ru.antufiev.coursework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.antufiev.coursework.entity.Book;
import ru.antufiev.coursework.entity.BookType;
import ru.antufiev.coursework.entity.Client;
import ru.antufiev.coursework.entity.Record;
import ru.antufiev.coursework.repository.BooksRepository;
import ru.antufiev.coursework.repository.BooksTypesRepository;
import ru.antufiev.coursework.repository.ClientsRepository;
import ru.antufiev.coursework.repository.JournalRepository;

@Component
public class TestDataInit implements CommandLineRunner {

  @Autowired
  JournalRepository repository;

  @Autowired
  BooksRepository booksRepository;

  @Autowired
  BooksTypesRepository booksTypesRepository;

  @Autowired
  ClientsRepository clientsRepository;


  @Override
  public void run(String... args) throws Exception {
    BookType bookType = new BookType("Comedy", 12, 1, 21);
    Book book = new Book("Avstrali", 12, bookType);
    Client client = new Client("Vasya", "Vasilievich", "Vasiliev", 12313223, 123123);
    repository.save(new Record(book, client, "2001-12-22", "2002-12-22", "2003-01-01"));

  }

}