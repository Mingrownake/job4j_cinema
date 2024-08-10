package ru.job4j.services;

import org.springframework.stereotype.Service;
import ru.job4j.dto.FilmSessionDTO;
import ru.job4j.repository.FilmRepository;
import ru.job4j.repository.FilmSessionRepository;
import ru.job4j.repository.HallsRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SimpleFilmSessionService implements FilmSessionService {
    private final FilmSessionRepository sql2oFilmSessionRepository;
    private final FilmRepository sql2oFilmRepository;
    private final HallsRepository sql2oHallRepository;

    public SimpleFilmSessionService(FilmSessionRepository sql2oFilmSessionRepository,
                                    FilmRepository sql2oFilmRepository,
                                    HallsRepository sql2oHallRepository) {
        this.sql2oFilmSessionRepository = sql2oFilmSessionRepository;
        this.sql2oFilmRepository = sql2oFilmRepository;
        this.sql2oHallRepository = sql2oHallRepository;
    }

    @Override
    public Collection<FilmSessionDTO> findAll() {
        var filmSessions = sql2oFilmSessionRepository.findAll();
        var films = sql2oFilmRepository.findAll();
        var halls = sql2oHallRepository.findAll();
        return filmSessions.stream().flatMap(filmSession ->
                films.stream().flatMap(film ->
                        halls.stream().filter(hall -> filmSession.getFilmId() == film.getId() && filmSession.getHallsId() == hall.getId())
                                .map(hall -> new FilmSessionDTO(filmSession.getId(), film.getName(), hall.getName(),
                                        filmSession.getStartDateTime(), filmSession.getEndDateTime(), filmSession.getPrice()))))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FilmSessionDTO> findById(int id) {
        return Optional.empty();
    }
}
