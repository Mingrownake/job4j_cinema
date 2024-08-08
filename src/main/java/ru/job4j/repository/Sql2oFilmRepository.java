package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.job4j.dto.FilmDTO;
import ru.job4j.models.Film;

import java.util.Collection;
import java.util.Optional;

@Repository
public class Sql2oFilmRepository implements FilmRepository {
    private Sql2o sql2o;

    public Sql2oFilmRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Film> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Film> findAll() {
        try (Connection con = sql2o.open()) {
           var query = con.createQuery("select * from films");
           return query.setColumnMappings(Film.COLUMN_MAPPING).executeAndFetch(Film.class);

        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Optional<Film> save(Film film) {
        return Optional.empty();
    }

    @Override
    public boolean update(Film film) {
        return false;
    }
}
