package ru.antufiev.coursework.service;

import ru.antufiev.coursework.entity.Record;

import java.util.List;

public interface JournalService {
  List<Record> listRecord();
  Record findRecordById(long id);
  Record addRecord(Record record);
  boolean isExist(Record record);
}
