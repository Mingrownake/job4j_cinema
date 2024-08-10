package ru.job4j.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.services.FilmSessionService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    private final FilmSessionService filmSessionService;

    public ScheduleController(FilmSessionService filmSessionService) {
        this.filmSessionService = filmSessionService;
    }

    @GetMapping()
    public String getSchedule(Model model) {
        model.addAttribute("filmSessions", filmSessionService.findAll());
        return "schedule/list";
    }
}
