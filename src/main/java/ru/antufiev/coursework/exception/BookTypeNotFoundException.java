package ru.antufiev.coursework.exception;

public class BookTypeNotFoundException extends RuntimeException{

  public BookTypeNotFoundException(String message) {
    super(message);
  }
}
