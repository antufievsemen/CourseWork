package ru.antufiev.coursework.repository;

import org.springframework.data.repository.CrudRepository;
import ru.antufiev.coursework.entity.Clients;

public interface ClientsRepository extends CrudRepository<Clients, Long> {
}
