package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.job4j.models.Halls;

import java.util.Collection;
import java.util.Optional;

@Repository
public class Sql2oHallsRepository implements HallsRepository {
    private final Sql2o sql2o;

    public Sql2oHallsRepository(Sql2o sql2o) {
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
        try (Connection con = sql2o.open()) {
            var query = con.createQuery("select * from halls where id = :id").addParameter("id", id);
            return Optional.ofNullable(query.setColumnMappings(Halls.COLUMN_MAPPING).executeAndFetchFirst(Halls.class));
        }
    }
}
