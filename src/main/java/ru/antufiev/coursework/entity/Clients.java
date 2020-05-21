package ru.antufiev.coursework.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Clients {
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
  private String passportSeria;

  @Column(name = "passportNum", nullable = false, unique = false)
  private String passportNum;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "client_id")
  private Set<Journal> references;

  public Clients() {

  }

  public Clients(String firstName, String secondName, String fatherName, String passportSeria, String passportNum) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.fatherName = fatherName;
    this.passportSeria = passportSeria;
    this.passportNum = passportNum;
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

  public String getPassportSeria() {
    return passportSeria;
  }

  public void setPassportSeria(String passportSeria) {
    this.passportSeria = passportSeria;
  }

  public String getPassportNum() {
    return passportNum;
  }

  public void setPassportNum(String passportNum) {
    this.passportNum = passportNum;
  }

  public Set<Journal> getReferences() {
    return references;
  }

  public void setReferences(Set<Journal> references) {
    this.references = references;
  }

  @Override
  public String toString() {
    return "Clients{" +
            "clientId=" + clientId +
            ", firstName='" + firstName + '\'' +
            ", secondName='" + secondName + '\'' +
            ", fatherName='" + fatherName + '\'' +
            ", passportSeria='" + passportSeria + '\'' +
            ", passportNum='" + passportNum + '\'' +
            ", references=" + references +
            '}';
  }
}
