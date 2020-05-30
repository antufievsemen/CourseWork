package ru.antufiev.coursework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BookTypes")
public class BookType {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private long bookTypeId;

  @Column(name = "name", nullable = false, unique = false)
  private String name;

  @Column(name = "count", nullable = false, unique = false)
  private long count;

  @Column(name = "fine", nullable = false, unique = false)
  private long fine;

  @Column(name = "dayCount", nullable = false, unique = false)
  private long dayCount;

  public BookType() {

  }

  public BookType(String name, long count, long fine, long dayCount) {
    this.name = name;
    this.count = count;
    this.fine = fine;
    this.dayCount = dayCount;
  }

  public long getBookTypeId() {
    return bookTypeId;
  }

  public void setBookTypeId(long bookTypeId) {
    this.bookTypeId = bookTypeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public long getFine() {
    return fine;
  }

  public void setFine(long fine) {
    this.fine = fine;
  }

  public long getDayCount() {
    return dayCount;
  }

  public void setDayCount(long dayCount) {
    this.dayCount = dayCount;
  }

  @Override
  public String toString() {
    return "BookType{" +
            "bookTypeId=" + bookTypeId +
            ", name='" + name + '\'' +
            ", count=" + count +
            ", fine=" + fine +
            ", dayCount=" + dayCount +
            '}';
  }
}
