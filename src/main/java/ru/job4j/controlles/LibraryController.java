package ru.job4j.controlles;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.services.FilmService;

@Component
@RequestMapping("/library")
public class LibraryController {
    private final FilmService filmService;

    public LibraryController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public String getLibrary(Model model) {
        model.addAttribute("films", filmService.findAll());
        return "library/list";
    }
}
