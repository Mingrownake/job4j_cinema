package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.job4j.models.FilmSession;

import java.util.Collection;
import java.util.Optional;

@Repository
public class Sql2oFilmSessionRepository implements FilmSessionRepository {
    private final Sql2o sql2o;

    public Sql2oFilmSessionRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Collection<FilmSession> findAll() {
        try (Connection con = sql2o.open()) {
            var sql = "select * from film_sessions";
            return con.createQuery(sql).setColumnMappings(FilmSession.COLUMN_MAPPING).executeAndFetch(FilmSession.class);
        }
    }

    @Override
    public Optional<FilmSession> findById(int id) {
        try (Connection con = sql2o.open()) {
            var sql = "select * from film_sessions where id = :id";
            return Optional.ofNullable(con.createQuery(sql)
                    .addParameter("id", id)
                    .setColumnMappings(FilmSession.COLUMN_MAPPING)
                    .executeAndFetchFirst(FilmSession.class));
        }
    }
}
