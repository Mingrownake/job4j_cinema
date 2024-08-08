package ru.job4j.repository;

import ru.job4j.models.Film;
import ru.job4j.models.Genre;

import java.util.Collection;
import java.util.Optional;

public interface GenreRepository {
    public Optional<Genre> findById(int id);

    public Collection<Genre> findAll();

    public void deleteById(int id);

    public Optional<Genre> save(Genre genre);

    public boolean update(Genre genre);
}
