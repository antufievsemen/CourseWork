package ru.antufiev.coursework.repository;

import org.springframework.data.repository.CrudRepository;
import ru.antufiev.coursework.entity.Journal;

public interface JournalRepository extends CrudRepository<Journal, Long> {
}
