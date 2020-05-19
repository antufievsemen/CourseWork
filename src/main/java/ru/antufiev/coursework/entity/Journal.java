package ru.antufiev.coursework.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Journal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "bookId")
  private Books bookId;

  @Column(name = "clientId")
  private Clients clientId;

  @Column(name = "dateBegin")
  private Date dateBegin;

  @Column(name = "dateEnd")
  private Date dataEnd;

  @Column(name = "dataRet")
  private Date dataRet;
}
