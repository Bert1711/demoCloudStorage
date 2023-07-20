package ru.zaroyan.democloudstorage.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zaroyan.democloudstorage.model.FileCloud;
import java.util.List;

@Repository
public interface FileCloudRepository extends JpaRepository<FileCloud, Long> {
    List<FileCloud> findByUser_Username(String username);
}
