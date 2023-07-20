package ru.zaroyan.democloudstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zaroyan.democloudstorage.model.FileCloud;

public interface FileCloudRepository extends JpaRepository<FileCloud, Long> {
}
