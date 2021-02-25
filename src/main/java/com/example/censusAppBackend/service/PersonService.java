package com.example.censusAppBackend.service;

import com.example.censusAppBackend.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService implements UserDetailsService {
   private final PersonRepository personRepository;
   private final static String USER_NOT_FOUND_MESSAGE = "OBS User with email %s not found!";
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return personRepository.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE,email)));
    }
}
