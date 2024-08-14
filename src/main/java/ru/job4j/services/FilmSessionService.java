package ru.job4j.services;

import ru.job4j.dto.FilmSessionDTO;
import ru.job4j.models.FilmSession;

import java.util.Collection;
import java.util.Optional;

public interface FilmSessionService {

    Collection<FilmSessionDTO> findAll();

    Optional<FilmSession> findById(int id);
}
