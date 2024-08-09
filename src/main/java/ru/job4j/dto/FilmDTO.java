package ru.job4j.dto;

import java.util.Map;
import java.util.Objects;

public class FilmDTO {
    private int id;
    private String name;
    private String description;
    private int year;
    private String genre;
    private int fileId;
    private int minimalAge;
    private int durationInMinutes;

    public FilmDTO() {

    }

    public FilmDTO(String name, String description, int year, String genre, int fileId,
                   int minimalAge, int durationInMinutes) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.genre = genre;
        this.fileId = fileId;
        this.minimalAge = minimalAge;
        this.durationInMinutes = durationInMinutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
}
