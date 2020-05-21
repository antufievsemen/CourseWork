package ru.antufiev.coursework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;;
import ru.antufiev.coursework.entity.BookTypes;
import ru.antufiev.coursework.entity.Books;
import ru.antufiev.coursework.entity.Clients;
import ru.antufiev.coursework.entity.Journal;
import ru.antufiev.coursework.repository.BooksRepository;
import ru.antufiev.coursework.repository.BooksTypesRepository;
import ru.antufiev.coursework.repository.ClientsRepository;
import ru.antufiev.coursework.repository.JournalRepository;

@SpringBootApplication
public class CourseworkApplication {

  public static void main(String[] args) {
    SpringApplication.run(CourseworkApplication.class, args);
  }

  @Bean
  public CommandLineRunner test(JournalRepository repJournal,
                                ClientsRepository repClients,
                                BooksTypesRepository repBookTypes,
                                BooksRepository repBooks) {
    Clients client1 = new Clients("Danya", "Gregoriev", "Vasilievich", "1322", "123425");
    repClients.save(client1);
    BookTypes bookTypeComedy = new BookTypes("comedy", 10, 100, 10);
    repBookTypes.save(bookTypeComedy);
    Books book1 = new Books("Pushkin", 1, bookTypeComedy);
    repBooks.save(book1);
    Journal journal = new Journal(book1, client1, "2000-11-12", "2001-12-19", "2000-11-12");
    repJournal.save(journal);
    return args -> {
      System.out.println(journal.toString());
    };
  }

}
