package ru.antufiev.coursework.repository;

import org.springframework.data.repository.CrudRepository;
import ru.antufiev.coursework.entity.Record;

public interface JournalRepository extends CrudRepository<Record, Long> {
}
