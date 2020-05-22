package ru.antufiev.coursework.entity;

import org.springframework.beans.factory.annotation.Autowired;
import ru.antufiev.coursework.repository.BooksRepository;
import ru.antufiev.coursework.repository.ClientsRepository;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Journal")
public class Record {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private long journalId;

  @ManyToOne(cascade = CascadeType.ALL)
  private Book book;

  @ManyToOne(cascade = CascadeType.ALL)
  private Client client;

  @Column(name = "dateBegin", nullable = false, unique = false)
  private LocalDate dateBegin;

  @Column(name = "dateEnd", nullable = false, unique = false)
  private LocalDate dateEnd;

  @Column(name = "dataRet", nullable = true, unique = false)
  private LocalDate dateRet;

  public Record() {

  }

  public Record(Book book, Client client, String dateBegin, String dateEnd, String dateRet) {
    this.book = book;
    this.client = client;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    this.dateBegin = LocalDate.parse(dateBegin, dateTimeFormatter);
    this.dateEnd = LocalDate.parse(dateEnd, dateTimeFormatter);
    this.dateRet = LocalDate.parse(dateRet, dateTimeFormatter);
  }



  public long getJournalId() {
    return journalId;
  }

  public void setJournalId(long journalId) {
    this.journalId = journalId;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public LocalDate getDateBegin() {
    return dateBegin;
  }

  public void setDateBegin(LocalDate dateBegin) {
    this.dateBegin = dateBegin;
  }

  public LocalDate getDateEnd() {
    return dateEnd;
  }

  public void setDateEnd(LocalDate dateEnd) {
    this.dateEnd = dateEnd;
  }

  public LocalDate getDateRet() {
    return dateRet;
  }

  public void setDateRet(LocalDate dateRet) {
    this.dateRet = dateRet;
  }

  @Override
  public String toString() {
    return "Record{" +
            "journalId=" + journalId +
            ", book=" + book +
            ", client=" + client +
            ", dateBegin=" + dateBegin +
            ", dateEnd=" + dateEnd +
            ", dateRet=" + dateRet +
            '}';
  }

  public boolean isEquals(Record record) {
    if (this.book.isEquals(record.getBook())) {
      if (this.client.isEquals(record.getClient())) {
        if (this.dateBegin.equals(record.getDateBegin())) {
          if (this.dateEnd.equals(record.getDateEnd())) {
            if (this.dateRet.equals(record.getDateRet())) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}
