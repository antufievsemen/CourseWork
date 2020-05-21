package ru.antufiev.coursework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private long bookId;

  @Column(name = "name", nullable = false, unique = false)
  private String name;

  @Column(name = "count", nullable = false, unique = false)
  private long count;

  @ManyToOne
  private BookTypes bookTypes;

  public Books() {
  }

  public Books(String name, long count, BookTypes bookTypes) {
    this.name = name;
    this.count = count;
    this.bookTypes = bookTypes;
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

  public BookTypes getBookTypes() {
    return bookTypes;
  }

  public void setBookTypes(BookTypes bookTypes) {
    this.bookTypes = bookTypes;
  }

  @Override
  public String toString() {
    return "Books{" +
            "bookId=" + bookId +
            ", name='" + name + '\'' +
            ", count=" + count +
            ", bookTypes=" + bookTypes +
            '}';
  }
}
