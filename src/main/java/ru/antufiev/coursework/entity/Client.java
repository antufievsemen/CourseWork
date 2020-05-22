package ru.antufiev.coursework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clients")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private long clientId;

  @Column(name = "firstName", nullable = false, unique = false)
  private String firstName;

  @Column(name = "secondName", nullable = false, unique = false)
  private String secondName;

  @Column(name = "fatherName", nullable = false, unique = false)
  private String fatherName;

  @Column(name = "passportSeria", nullable = false, unique = false)
  private long passportSeria;

  @Column(name = "passportNum", nullable = false, unique = false)
  private long passportNum;

  public Client() {

  }

  public Client(String firstName, String secondName, String fatherName, long passportSeria, long passportNum) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.fatherName = fatherName;
    this.passportSeria = passportSeria;
    this.passportNum = passportNum;
  }

  public long getClientId() {
    return clientId;
  }

  public void setClientId(long clientId) {
    this.clientId = clientId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public long getPassportSeria() {
    return passportSeria;
  }

  public void setPassportSeria(long passportSeria) {
    this.passportSeria = passportSeria;
  }

  public long getPassportNum() {
    return passportNum;
  }

  public void setPassportNum(long passportNum) {
    this.passportNum = passportNum;
  }

  @Override
  public String toString() {
    return "Client{" +
            "clientId=" + clientId +
            ", firstName='" + firstName + '\'' +
            ", secondName='" + secondName + '\'' +
            ", fatherName='" + fatherName + '\'' +
            ", passportSeria='" + passportSeria + '\'' +
            ", passportNum='" + passportNum + '\'' +
            '}';
  }

  public boolean isEquals(Client client) {
    if (this.firstName.equals(client.getFirstName())) {
      if (this.secondName.equals(client.getSecondName())) {
        if (this.fatherName.equals(client.getFatherName())) {
          if (this.passportSeria == client.getPassportSeria()) {
            if (this.passportNum == client.getPassportNum()) {
              return true;
            }
          }
        }
      }

    }
    return false;
  }

}
