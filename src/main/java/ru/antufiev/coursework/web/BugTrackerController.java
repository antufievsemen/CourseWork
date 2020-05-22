package ru.antufiev.coursework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.antufiev.coursework.entity.Book;
import ru.antufiev.coursework.entity.BookType;
import ru.antufiev.coursework.entity.Client;
import ru.antufiev.coursework.entity.Record;
import ru.antufiev.coursework.exception.*;
import ru.antufiev.coursework.service.BookService;
import ru.antufiev.coursework.service.BookTypeService;
import ru.antufiev.coursework.service.ClientService;
import ru.antufiev.coursework.service.JournalService;

import java.util.List;

@RestController
@RequestMapping("/bd")
public class BugTrackerController {

  private BookService bookService;
  private ClientService clientService;
  private JournalService journalService;
  private BookTypeService bookTypeService;

  @GetMapping("/records")
  public ResponseEntity<List<Record>> getAllRecords() {
    return new ResponseEntity<>(journalService.listRecord(), HttpStatus.OK);
  }

  @GetMapping("/record/{id}")
  public ResponseEntity<Record> getRecordById(@PathVariable("id") long id) {
    try {
      return new ResponseEntity<>(journalService.findRecordById(id), HttpStatus.OK);
    } catch (RecordNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found");
    }
  }

  @PostMapping(value = "/addRecord", consumes = "application/json", produces = "application/json")
  public Record addRecord(@RequestBody Record record) {
    if (journalService.isExist(record)) {
      throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "This record already exist");
    }
    Client client = record.getClient();
    if (!clientService.isExist(client)) {
      clientService.addClient(client);
    }
    Book book = record.getBook();
    if (!bookService.isExist(book)) {
      bookService.addBook(book);
    }
    BookType bookType = book.getBookType();
    if (!bookTypeService.isExist(bookType)) {
      bookTypeService.addBookType(bookType);
    }
    return journalService.addRecord(record);
  }

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getAllBooks() {
    return new ResponseEntity<>(bookService.listBooks(), HttpStatus.OK);
  }

  @GetMapping("/book/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable("id") long id) {
    try{
      return new ResponseEntity<>(bookService.findBookById(id), HttpStatus.OK);
    } catch (BookNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
    }
  }

  @PostMapping(value = "/addBook", consumes = "application/json", produces = "application/json")
  public Book addBook(@RequestBody Book book) {
    if (bookTypeService.isExist(book.getBookType())) {
      return bookService.addBook(book);
    } else {
      bookTypeService.addBookType(book.getBookType());
      return bookService.addBook(book);
    }
  }

  @GetMapping("/clients")
  public ResponseEntity<List<Client>> getAllClients() {
    return new ResponseEntity<>(clientService.listClient(), HttpStatus.OK);
  }

  @GetMapping("/client/{id}")
  public ResponseEntity<Client> getClientById(@PathVariable("id") long id) {
    try{
      return new ResponseEntity<>(clientService.findClientById(id), HttpStatus.OK);
    } catch (ClientNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
    }
  }

  @PostMapping(value = "/addClient", consumes = "application/json", produces = "application/json")
  public Client addClient(@RequestBody Client client) {
    if (!clientService.isExist(client)) {
      return clientService.addClient(client);
    }
    throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "This client already exist");
  }

  @GetMapping("/bookTypes")
  public ResponseEntity<List<BookType>> getAllBookTypes() {
    return new ResponseEntity<>(bookTypeService.listBookType(), HttpStatus.OK);
  }

  @GetMapping("/bookType/{id}")
  public ResponseEntity<BookType> getBookTypeById(@PathVariable("id") long id) {
    try{
      return new ResponseEntity<>(bookTypeService.findBookTypeById(id), HttpStatus.OK);
    } catch (BookTypeNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "BookType not found");
    }
  }

  @GetMapping("/bookType/lowerThen/{fine}")
  public ResponseEntity<List<BookType>> getListBookTypeLowerThen(@PathVariable("fine") long fine) {
    return new ResponseEntity<>(bookTypeService.listBookTypesLowFine(fine), HttpStatus.OK);
  }

  @PostMapping(value = "/addBookType", consumes = "application/json", produces = "application/json")
  public BookType addBookType(@RequestBody BookType bookType) {
    if (!bookTypeService.isExist(bookType)) {
      return bookTypeService.addBookType(bookType);
    }
    throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "This book type already exist");
  }



  @Autowired
  public void setBookService(BookService bookService) {
    this.bookService = bookService;
  }

  @Autowired
  public void setClientService(ClientService clientService) {
    this.clientService = clientService;
  }

  @Autowired
  public void setJournalService(JournalService journalService) {
    this.journalService = journalService;
  }

  @Autowired
  public void setBookTypeService(BookTypeService bookTypeService) {
    this.bookTypeService = bookTypeService;
  }
}
