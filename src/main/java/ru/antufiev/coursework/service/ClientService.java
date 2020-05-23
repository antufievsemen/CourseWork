package ru.antufiev.coursework.service;

import ru.antufiev.coursework.entity.BookType;
import ru.antufiev.coursework.entity.Client;

import java.util.List;

public interface ClientService {
  List<Client> listClient();
  Client findClientById(long id);
  boolean isExist(Client client);
  Client addClient(Client client);
  Client deleteClient(long id);
  List<Client> updateClient(Client client);
}
