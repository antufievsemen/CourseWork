package ru.antufiev.coursework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.antufiev.coursework.entity.User;
import ru.antufiev.coursework.repository.UserRepository;

import java.util.Collections;

@Component
public class TestDataInit implements CommandLineRunner {

  @Autowired
  UserRepository userRep;

  @Autowired
  PasswordEncoder pwdEncoder;

  @Override
  public void run(String... args) throws Exception {
    userRep.save(new User("user", pwdEncoder.encode("pwd"), Collections.singletonList("ROLE_USER")));
    userRep.save(new User("admin", pwdEncoder.encode("apwd"), Collections.singletonList("ROLE_ADMIN")));
  }
}