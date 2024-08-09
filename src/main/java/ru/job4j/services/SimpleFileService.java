package ru.job4j.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.job4j.dto.FileDTO;
import ru.job4j.models.File;
import ru.job4j.repository.FileRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class SimpleFileService implements FileService {
    private final FileRepository sql2oFileRepository;

    private String directionStorage;

    public SimpleFileService(FileRepository sql2oFileRepository,
                             @Value("${file.directory}") String fileDirectory) {
        this.sql2oFileRepository = sql2oFileRepository;
        this.directionStorage = fileDirectory;
        createDirectory(directionStorage);
    }

    private void createDirectory(String directory) {
        try {
            Path path = Path.of(directory);
            if (!path.toFile().exists()) {
                Files.createDirectory(path);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Override
    public Optional<File> save(FileDTO fileDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<FileDTO> findById(int id) {
        var file = sql2oFileRepository.findById(id);
        if (file.isEmpty()) {
            return Optional.empty();
        }
        var content = readFileAsByte(file.get().getPath());
        return Optional.of(new FileDTO(file.get().getName(), content));
    }

    private byte[] readFileAsByte(String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {

    }
}
