package ru.antufiev.coursework.repository;

import org.springframework.data.repository.CrudRepository;
import ru.antufiev.coursework.entity.Client;

public interface ClientsRepository extends CrudRepository<Client, Long> {
}
