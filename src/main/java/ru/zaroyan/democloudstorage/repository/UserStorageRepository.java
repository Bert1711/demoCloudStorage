package ru.zaroyan.democloudstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zaroyan.democloudstorage.model.UserStorage;
@Repository
public interface UserStorageRepository extends JpaRepository<UserStorage, String> {

    UserStorage findByUsername(String username);

}

