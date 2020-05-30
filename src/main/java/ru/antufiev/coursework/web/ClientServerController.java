package ru.antufiev.coursework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.antufiev.coursework.entity.Book;
import ru.antufiev.coursework.entity.BookType;
import ru.antufiev.coursework.entity.Client;
import ru.antufiev.coursework.entity.Record;
import ru.antufiev.coursework.service.BookService;
import ru.antufiev.coursework.service.BookTypeService;
import ru.antufiev.coursework.service.ClientService;
import ru.antufiev.coursework.service.JournalService;

import java.util.List;

@Controller
public class ClientServerController {

  @Autowired
  private BookTypeService bookTypeService;

  @Autowired
  private ClientService clientService;

  @Autowired
  private BookService bookService;

  @Autowired
  private JournalService journalService;

  @GetMapping("/bookTypes")
  public String getAllBookTypes(Model model) {
    List<BookType> bookTypes = bookTypeService.listBookType();
    model.addAttribute("bookTypes", bookTypes);
    return "bookTypeTemplate/type-list";
  }

  @GetMapping("/type-add")
  public String addBookTypeForm(BookType bookType) {
    return "bookTypeTemplate/type-add";
  }

  @PostMapping("/type-add")
  public String addBookType(BookType bookType) {
    bookTypeService.addBookType(bookType);
    return "redirect:/bookTypes";
  }

  @GetMapping("type-delete/{id}")
  public String deleteBookType(@PathVariable("id") long id) {
    bookTypeService.deleteBookType(id);
    return "redirect:/bookTypes";
  }

  @GetMapping("type-update/{id}")
  public String updateBookType(@PathVariable("id") Long id, Model model) {
    BookType bookType = bookTypeService.findBookTypeById(id);
    model.addAttribute("bookType", bookType);
    return "bookTypeTemplate/type-update";
  }

  @PostMapping("/type-update")
  public String updateBookType(BookType bookType) {
    bookTypeService.updateBookType(bookType);
    return "redirect:/bookTypes";
  }

  @GetMapping("/clients")
  public String getAllClients(Model model) {
    List<Client> clients = clientService.listClient();
    model.addAttribute("clients", clients);
    return "clientTemplate/client-list";
  }

  @GetMapping("/client-add")
  public String addClientForm(Client client) {
    return "clientTemplate/client-add";
  }

  @PostMapping("/client-add")
  public String addClient(Client client) {
    clientService.addClient(client);
    return "redirect:/clients";
  }

  @GetMapping("client-delete/{id}")
  public String deleteClient(@PathVariable("id") long id) {
    clientService.deleteClient(id);
    return "redirect:/clients";
  }

  @GetMapping("client-update/{id}")
  public String updateBook(@PathVariable("id") Long id, Model model) {
    Client client = clientService.findClientById(id);
    model.addAttribute("client", client);
    return "clientTemplate/client-update";
  }

  @PostMapping("/client-update")
  public String updateClient(Client client) {
    clientService.updateClient(client);
    return "redirect:/clients";
  }

  @GetMapping("/books")
  public String getAllBooks(Model model) {
    List<Book> books = bookService.listBooks();
    model.addAttribute("books", books);
    return "bookTemplate/book-list";
  }

  @GetMapping("/book-add")
  public String addBookForm(Book book) {
    return "bookTemplate/book-add";
  }

  @PostMapping("/book-add")
  public String addBook(Book book) {
    bookService.addBook(book);
    bookTypeService.addBookType(book.getBookType());
    return "redirect:/books";
  }

  @GetMapping("book-delete/{id}")
  public String deleteBook(@PathVariable("id") long id) {
    bookService.deleteBook(id);
    return "redirect:/books";
  }

  @GetMapping("book-update/{id}")
  public String updateBooks(@PathVariable("id") Long id, Model model) {
    Book book = bookService.findBookById(id);
    model.addAttribute("book", book);
    return "bookTemplate/book-update";
  }

  @PostMapping("/book-update")
  public String updateBook(Book book) {
    bookService.updateBook(book);
    return "redirect:/books";
  }

  //

  @GetMapping("/journal")
  public String getAllRecords(Model model) {
    List<Record> records = journalService.listRecord();
    model.addAttribute("records", records);
    return "journalTemplate/journal-list";
  }

  @GetMapping("/journal-add")
  public String addRecordForm(Record record) {
    return "journalTemplate/journal-add";
  }

  @PostMapping("/journal-add")
  public String addRecord(Record record) {
    journalService.addRecord(record);
    bookService.addBook(record.getBook());
    bookTypeService.addBookType(record.getBook().getBookType());
    return "redirect:/journal";
  }

  @GetMapping("journal-delete/{id}")
  public String deleteRecord(@PathVariable("id") long id) {
    journalService.deleteRecord(id);
    return "redirect:/journal";
  }

  @GetMapping("journal-update/{id}")
  public String updateRecord(@PathVariable("id") Long id, Model model) {
    Record record = journalService.findRecordById(id);
    model.addAttribute("record", record);
    return "journalTemplate/journal-update";
  }

  @PostMapping("/journal-update")
  public String updateRecord(Record record) {
    journalService.updateRecord(record);
    return "redirect:/journal";
  }

  @GetMapping("/mainMenu")
  public String mainMenu(){
    return "index";
  }

}
