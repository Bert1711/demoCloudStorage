package ru.zaroyan.democloudstorage.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zaroyan.democloudstorage.model.FileStorage;
import java.util.List;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {
    List<FileStorage> findByUser_Username(String username);
}
