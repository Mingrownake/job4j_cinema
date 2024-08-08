package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.job4j.models.Genre;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class Sql2oGenreRepository implements GenreRepository {
    private final Sql2o sql2o;

    public Sql2oGenreRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Genre> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Genre> findAll() {
        try (Connection con = sql2o.open()) {
            var sql = "SELECT * FROM genres";
            return con.createQuery(sql).executeAndFetch(Genre.class);
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Optional<Genre> save(Genre genre) {
        return Optional.empty();
    }

    @Override
    public boolean update(Genre genre) {
        return false;
    }
}
