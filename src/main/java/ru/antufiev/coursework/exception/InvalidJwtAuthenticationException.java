package ru.antufiev.coursework.exception;

public class InvalidJwtAuthenticationException extends RuntimeException{

  public InvalidJwtAuthenticationException(String message) {
    super(message);
  }
}