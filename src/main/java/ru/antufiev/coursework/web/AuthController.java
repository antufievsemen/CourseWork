package ru.antufiev.coursework.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antufiev.coursework.repository.UserRepository;
import ru.antufiev.coursework.security.jwt.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bd/auth")
public class AuthController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @Autowired
  UserRepository userRep;

  @PostMapping("/signIn")
  public ResponseEntity signIn(@RequestBody AuthRequest request) {
    try{
      String name = request.getUserName();
      String token = jwtTokenProvider.createToken(
              name,
              userRep.findUserByUserName(name)
                      .orElseThrow(() -> new UsernameNotFoundException("User not found")).getRoles()
      );
      Map<Object, Object> model = new HashMap<>();
      model.put("userName", name);
      model.put("token", token);

      return ResponseEntity.ok(model);
    } catch (AuthenticationException e) {
      throw new BadCredentialsException("Invalid username of password");
    }
  }
}
