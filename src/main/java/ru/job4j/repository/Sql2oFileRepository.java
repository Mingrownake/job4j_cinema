package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.job4j.models.File;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class Sql2oFileRepository implements FileRepository {
    private final Sql2o sql2o;

    public Sql2oFileRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<File> findById(int id) {
        try (Connection con = sql2o.open()) {
            var sql = "SELECT * FROM files WHERE id = :id";
            var result = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(File.class);
            return Optional.ofNullable(result);
        }
    }

    @Override
    public Collection<File> findAll() {
        try (Connection con = sql2o.open()) {
            var sql = "SELECT * FROM files";
            return con.createQuery(sql).executeAndFetch(File.class);
        }
    }
}
