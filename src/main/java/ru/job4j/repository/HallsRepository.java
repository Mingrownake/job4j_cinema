package ru.job4j.repository;

import ru.job4j.models.Halls;

import java.util.Collection;
import java.util.Optional;

public interface HallsRepository {
    public Collection<Halls> findAll();

    public Optional<Halls> findById(int id);
}
