package ru.antufiev.coursework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "journal")
public class Journal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private long journalId;

  @ManyToOne
  private Books bookId;

  @ManyToOne
  private Clients clientId;

  @Column(name = "dateBegin", nullable = false, unique = false)
  private LocalDate dateBegin;

  @Column(name = "dateEnd", nullable = false, unique = false)
  private LocalDate dateEnd;

  @Column(name = "dataRet", nullable = true, unique = false)
  private LocalDate dateRet;

  public Journal() {

  }

  public Journal(Books bookId, Clients clientId, String dateBegin, String dateEnd, String dateRet) {
    this.bookId = bookId;
    this.clientId = clientId;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    this.dateBegin = LocalDate.parse(dateBegin, dateTimeFormatter);
    this.dateEnd = LocalDate.parse(dateEnd, dateTimeFormatter);
    this.dateRet = LocalDate.parse(dateRet, dateTimeFormatter);
  }

  public Books getBookId() {
    return bookId;
  }

  public void setBookId(Books bookId) {
    this.bookId = bookId;
  }

  public Clients getClientId() {
    return clientId;
  }

  public void setClientId(Clients clientId) {
    this.clientId = clientId;
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
    return "Journal{" +
            "journalId=" + journalId +
            ", bookId=" + bookId +
            ", clientId=" + clientId +
            ", dateBegin=" + dateBegin +
            ", dateEnd=" + dateEnd +
            ", dateRet=" + dateRet +
            '}';
  }
}
