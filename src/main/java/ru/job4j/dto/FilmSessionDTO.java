package ru.job4j.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FilmSessionDTO {
    private int id;
    private String filmName;
    private String hallName;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int price;

    public FilmSessionDTO() {

    }

    public FilmSessionDTO(int id, String filmName, String hallName, LocalDateTime startDateTime, LocalDateTime endDateTime, int price) {
        this.id = id;
        this.filmName = filmName;
        this.hallName = hallName;
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

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public String getFormattedStartDateTime() {
        return startDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public String getFormattedEndDateTime() {
        return endDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
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

}
