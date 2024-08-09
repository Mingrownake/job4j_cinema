package ru.job4j.services;

import org.springframework.stereotype.Service;
import ru.job4j.dto.FilmDTO;
import ru.job4j.models.Film;
import ru.job4j.repository.FilmRepository;
import ru.job4j.repository.GenreRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SimpleFilmService implements FilmService {
    private final FilmRepository sql2oFilmRepository;
    private final GenreRepository sql2oGenreRepository;

    public SimpleFilmService(FilmRepository sql2oFilmRepository,
                             GenreRepository sql2oGenreRepository) {
        this.sql2oFilmRepository = sql2oFilmRepository;
        this.sql2oGenreRepository = sql2oGenreRepository;
    }

    @Override
    public Optional<Film> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<FilmDTO> findAll() {
        var films = sql2oFilmRepository.findAll();
        var genres = sql2oGenreRepository.findAll();
        return films.stream().flatMap(film ->
                genres.stream().filter(genre -> film.getGenreId() == genre.getId())
                        .map(genre -> new FilmDTO(film.getName(), film.getDescription(), film.getYear(),
                                genre.getName(), film.getFileId(), film.getMinimalAge(), film.getDurationInMinutes()))
                        .peek(filmDTO -> filmDTO.setId(film.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Film save(Film film) {
        return null;
    }

    @Override
    public boolean update(Film film) {
        return false;
    }
}
