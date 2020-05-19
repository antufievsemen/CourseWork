package ru.antufiev.coursework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookTypes {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "count")
  private long count;

  @Column(name = "fine")
  private String fine;

  @Column(name = "dayCount")
  private long dayCount;

  public BookTypes() {

  }

  public BookTypes(String name, long count, String fine, long dayCount) {
    this.name = name;
    this.count = count;
    this.fine = fine;
    this.dayCount = dayCount;
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

  public String getFine() {
    return fine;
  }

  public void setFine(String fine) {
    this.fine = fine;
  }

  public long getDayCount() {
    return dayCount;
  }

  public void setDayCount(long dayCount) {
    this.dayCount = dayCount;
  }
}
