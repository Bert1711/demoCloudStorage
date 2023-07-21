package ru.zaroyan.democloudstorage.services;
import org.springframework.stereotype.Service;
import ru.zaroyan.democloudstorage.model.FileStorage;
import ru.zaroyan.democloudstorage.model.Person;
import ru.zaroyan.democloudstorage.repository.FileStorageRepository;

import java.util.List;

@Service
public class FileCloudService {

    private final FileStorageRepository fileRepository;

    public FileCloudService(FileStorageRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<FileStorage> getFilesByUser(Person user) {
        return fileRepository.findByUser_Username(user.getUsername());
    }

    public FileStorage saveFile(FileStorage file) {
        return fileRepository.save(file);
    }

    public void deleteFile(Long fileId) {
        fileRepository.deleteById(fileId);
    }

}
