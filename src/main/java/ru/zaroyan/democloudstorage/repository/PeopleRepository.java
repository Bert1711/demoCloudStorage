package ru.zaroyan.democloudstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zaroyan.democloudstorage.model.Person;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByUsername(String username);

}

