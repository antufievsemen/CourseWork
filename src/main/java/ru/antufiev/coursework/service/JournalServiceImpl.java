package ru.antufiev.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.antufiev.coursework.exception.RecordNotFoundException;
import ru.antufiev.coursework.entity.Book;
import ru.antufiev.coursework.entity.Client;
import ru.antufiev.coursework.entity.Record;
import ru.antufiev.coursework.repository.JournalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService{

  @Autowired
  private JournalRepository repository;

  @Override
  public List<Record> listRecord() {
    return (List<Record>) repository.findAll();
  }

  @Override
  public Record findRecordById(long id) {
    Optional<Record> optional = repository.findById(id);
    if (optional.isPresent()) {
      return optional.get();
    } else {
     throw new RecordNotFoundException("Record with id " + id + "doesnt exist");
    }
  }

  @Override
  public Record addRecord(Record record) {
    return repository.save(record);
  }

  @Override
  public boolean isExist(Record record) {
    List<Record> listRecord = (List<Record>) repository.findAll();
    for (Record element : listRecord) {
      if (record.isEquals(element)) {
        return true;
      }
    }
    return false;
  }
}
