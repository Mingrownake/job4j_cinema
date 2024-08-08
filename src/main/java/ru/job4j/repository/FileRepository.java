package ru.job4j.repository;

import ru.job4j.models.File;

import java.util.Collection;
import java.util.Optional;

public interface FileRepository {
    public Optional<File> findById(int id);

    public Collection<File> findAll();
}
