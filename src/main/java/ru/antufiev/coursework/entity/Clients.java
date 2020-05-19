package ru.antufiev.coursework.entity;

import javax.persistence.*;

@Entity
public class Clients {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "secondName")
  private String secondName;

  @Column(name = "fatherName")
  private String fatherName;

  @Column(name = "passportSeria")
  private String passportSeria;

  @Column(name = "passportNum")
  private String passportNum;
}
