package ru.antufiev.coursework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import ru.antufiev.coursework.security.jwt.JwtSecurityConfigurer;
import ru.antufiev.coursework.security.jwt.JwtTokenProvider;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean () throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.httpBasic().disable()
            .csrf().disable()
            .formLogin().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST,"/bd/auth/signIn").permitAll()
            .antMatchers(HttpMethod.GET, "/bd/books", "/bd/bookTypes", "/bd/book/{id}", "/bd/bookType/{id}").hasRole("USER")
            .antMatchers(HttpMethod.GET, "/bd/journal", "/bd/clients", "/bd/record/{id}", "/bd/client/{id}",
                    "/bd/books", "/bd/bookTypes", "/bd/book/{id}", "/bd/bookType/{id}").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/bd/addRecord", "/bd/addClient", "/bd/addBook", "/bd/addBookType").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/bd/updateRecord", "/bd/updateClient", "/bd/updateBook", "/bd/updateBookType").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/bd/deleteRecord/{id}", "/bd/deleteClient/{id}", "/bd/deleteBook/{id}", "/bd/deleteBookType/{id}").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .apply(new JwtSecurityConfigurer(jwtTokenProvider));

  }

}