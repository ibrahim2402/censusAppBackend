package com.example.censusAppBackend.repository;

import com.example.censusAppBackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByEmail(String email);
}
