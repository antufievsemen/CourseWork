package ru.antufiev.coursework.entity;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private long bookId;

  @Column(name = "name", nullable = false, unique = false)
  private String name;

  @Column(name = "count", nullable = false, unique = false)
  private long count;

  @ManyToOne(cascade = CascadeType.ALL)
  private BookType bookType;

  public Book() {
  }

  public Book(String name, long count, BookType bookType) {
    this.name = name;
    this.count = count;
    this.bookType = bookType;
  }

  public long getBookId() {
    return bookId;
  }

  public void setBookId(long bookId) {
    this.bookId = bookId;
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

  public BookType getBookType() {
    return bookType;
  }

  public void setBookType(BookType bookType) {
    this.bookType = bookType;
  }

  @Override
  public String toString() {
    return "Book{" +
            "bookId=" + bookId +
            ", name='" + name + '\'' +
            ", count=" + count +
            ", bookTypes=" + bookType +
            '}';
  }
}
