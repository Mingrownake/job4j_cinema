package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.job4j.models.Halls;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class Sql2o2HallsRepository implements HallsRepository {
    private final Sql2o sql2o;

    public Sql2o2HallsRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Collection<Halls> findAll() {
        try (Connection con = sql2o.open()) {
            var sql = "select * from halls";
            return con.createQuery(sql).setColumnMappings(Halls.COLUMN_MAPPING).executeAndFetch(Halls.class);
        }
    }

    @Override
    public Optional<Halls> findById(int id) {
        return Optional.empty();
    }
}
