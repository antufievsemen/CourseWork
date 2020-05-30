package ru.antufiev.coursework.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Journal")
public class Record {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private long recordId;

  @ManyToOne(cascade = CascadeType.ALL)
  private Book book;

  @ManyToOne(cascade = CascadeType.ALL)
  private Client client;

  @Column(name = "dateBegin", nullable = false, unique = false)
  private String dateBegin;

  @Column(name = "dateEnd", nullable = false, unique = false)
  private String dateEnd;

  @Column(name = "dataRet", nullable = true, unique = false)
  private String dateRet;

  public Record() {

  }

  public Record(Book book, Client client, String dateBegin, String dateEnd, String dateRet) {
    this.book = book;
    this.client = client;
    this.dateBegin = dateBegin;
    this.dateEnd = dateEnd;
    this.dateRet = dateRet;
  }



  public long getRecordId() {
    return recordId;
  }

  public void setRecordId(long journalId) {
    this.recordId = journalId;
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

  public String getDateBegin() {
    return dateBegin;
  }

  public void setDateBegin(String dateBegin) {
    this.dateBegin = dateBegin;
  }

  public String getDateEnd() {
    return dateEnd;
  }

  public void setDateEnd(String dateEnd) {
    this.dateEnd = dateEnd;
  }

  public String getDateRet() {
    return dateRet;
  }

  public void setDateRet(String dateRet) {
    this.dateRet = dateRet;
  }

  @Override
  public String toString() {
    return "Record{" +
            "journalId=" + recordId +
            ", book=" + book +
            ", client=" + client +
            ", dateBegin=" + dateBegin +
            ", dateEnd=" + dateEnd +
            ", dateRet=" + dateRet +
            '}';
  }
}
