package ru.job4j.repository;

import ru.job4j.models.FilmSession;

import java.util.Collection;
import java.util.Optional;

public interface FilmSessionRepository {

    public Collection<FilmSession> findAll();

    public Optional<FilmSession> findById(int id);
}
