package ru.zaroyan.democloudstorage.service;

import org.springframework.stereotype.Service;
import ru.zaroyan.democloudstorage.model.FileCloud;
import ru.zaroyan.democloudstorage.model.User;
import ru.zaroyan.democloudstorage.repository.FileCloudRepository;

import java.util.List;

@Service
public class FileCloudService {

    private final FileCloudRepository fileRepository;

    public FileCloudService(FileCloudRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<FileCloud> getFilesByUser(User user) {
        return fileRepository.findByUser_Username(user.getUsername());
    }

    public FileCloud saveFile(FileCloud file) {
        return fileRepository.save(file);
    }

    public void deleteFile(Long fileId) {
        fileRepository.deleteById(fileId);
    }

}
