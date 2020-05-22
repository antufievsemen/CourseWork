package ru.antufiev.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.antufiev.coursework.entity.Client;
import ru.antufiev.coursework.exception.ClientNotFoundException;
import ru.antufiev.coursework.repository.ClientsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientsRepository repository;

  @Override
  public List<Client> listClient() {
    return (List<Client>) repository.findAll();
  }

  @Override
  public Client findClientById(long id) {
    Optional<Client> optional = repository.findById(id);
    if (optional.isPresent()) {
      return optional.get();
    }
    throw new ClientNotFoundException("Client with id = " + id + "doesnt exist");
  }

  @Override
  public boolean isExist(Client client) {
    List<Client> listClient = (List<Client>) repository.findAll();
    for (Client element : listClient) {
      if (client.isEquals(element)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Client addClient(Client client) {
    return repository.save(client);
  }
}
