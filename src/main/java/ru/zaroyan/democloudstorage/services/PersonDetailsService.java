package ru.zaroyan.democloudstorage.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.zaroyan.democloudstorage.model.Person;
import ru.zaroyan.democloudstorage.repository.PeopleRepository;
import ru.zaroyan.democloudstorage.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    public PersonDetailsService(PeopleRepository userRepository) {
        this.peopleRepository = userRepository;
    }

    public Optional<Person>  findUserByUsername(String username) {
        return peopleRepository.findByUsername(username);
    }

    public Person saveUser(Person user) {
        return peopleRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> byUsername = peopleRepository.findByUsername(username);
        if(byUsername.isEmpty())
            throw new UsernameNotFoundException("Пользователь не найден!");
        return new PersonDetails(byUsername.get());
    }
}

