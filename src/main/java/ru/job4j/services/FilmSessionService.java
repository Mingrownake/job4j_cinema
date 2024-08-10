package ru.job4j.services;

import ru.job4j.dto.FilmSessionDTO;

import java.util.Collection;
import java.util.Optional;

public interface FilmSessionService {

    public Collection<FilmSessionDTO> findAll();

    public Optional<FilmSessionDTO> findById(int id);
}
