package ru.job4j.services;

import ru.job4j.dto.FileDTO;
import ru.job4j.models.File;

import java.util.Optional;

public interface FileService {
    public Optional<File> save(FileDTO fileDTO);

    public Optional<FileDTO> findById(int id);

    public void deleteById(int id);
}
