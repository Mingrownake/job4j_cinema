package ru.job4j.services;

import ru.job4j.dto.FilmDTO;
import ru.job4j.models.Film;

import java.util.Collection;
import java.util.Optional;

public interface FilmService {
    public Optional<Film> findById(int id);

    public Collection<FilmDTO> findAll();

    public void deleteById(int id);

    public Optional<Film> save(Film film);

    public boolean update(Film film);
}
