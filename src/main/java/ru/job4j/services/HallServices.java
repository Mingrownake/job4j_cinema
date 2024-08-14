package ru.job4j.services;

import ru.job4j.models.Halls;

import java.util.Collection;
import java.util.Optional;

public interface HallServices {
    Collection<Integer> getRowListById(int id);

    Collection<Integer> getPlaceListById(int id);

    Optional<Halls> findHallById(int id);
}
