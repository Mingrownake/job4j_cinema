package ru.job4j.services;

import org.springframework.stereotype.Service;
import ru.job4j.models.Halls;
import ru.job4j.repository.HallsRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SimpleHallServices implements HallServices {
    private final HallsRepository sql2oHallsRepository;

    public SimpleHallServices(HallsRepository sql2oHallsRepository) {
        this.sql2oHallsRepository = sql2oHallsRepository;
    }

    @Override
    public Collection<Integer> getRowListById(int id) {
        var hall = sql2oHallsRepository.findById(id).get();
        return getCountSequence(hall.getRowCount());
    }

    @Override
    public Collection<Integer> getPlaceListById(int id) {
        var hall = sql2oHallsRepository.findById(id).get();
        return getCountSequence(hall.getPlaceCount());
    }

    @Override
    public Optional<Halls> findHallById(int id) {
        return sql2oHallsRepository.findById(id);
    }

    private Collection<Integer> getCountSequence(int endNumber) {
        int startNumber = 1;
        return IntStream.range(startNumber, endNumber + 1).boxed().collect(Collectors.toList());
    }
}
