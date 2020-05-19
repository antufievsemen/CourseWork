package ru.antufiev.coursework.entity;

import javax.persistence.*;

@Entity
public class Books {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "count")
  private long count;

  @Column(name = "typeId")
  private long typeId;

  public Books() {}
  public Books(String name, long count, long typeId) {
    this.name = name;
    this.count = count;
    this.typeId = typeId;
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

  public long getTypeId() {
    return typeId;
  }

  public void setTypeId(long typeId) {
    this.typeId = typeId;
  }
}
