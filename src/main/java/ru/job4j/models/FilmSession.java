package ru.job4j.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class FilmSession {
    private int id;
    private int filmId;
    private int hallsId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int price;

    public FilmSession() {

    }

    public FilmSession(int filmId, int hallsId, LocalDateTime startDateTime, LocalDateTime endDateTime, int price) {
        this.filmId = filmId;
        this.hallsId = hallsId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getHallsId() {
        return hallsId;
    }

    public void setHallsId(int hallsId) {
        this.hallsId = hallsId;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FilmSession that = (FilmSession) o;
        return id == that.id && filmId == that.filmId && hallsId == that.hallsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filmId, hallsId);
    }
}
