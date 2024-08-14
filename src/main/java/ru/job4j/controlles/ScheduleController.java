package ru.job4j.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.models.User;
import ru.job4j.services.FilmService;
import ru.job4j.services.FilmSessionService;
import ru.job4j.services.HallServices;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    private final FilmSessionService filmSessionService;
    private final HallServices hallServices;
    private final FilmService filmService;

    public ScheduleController(FilmSessionService filmSessionService,
                              HallServices hallServices,
                              FilmService filmService) {
        this.filmSessionService = filmSessionService;
        this.hallServices = hallServices;
        this.filmService = filmService;
    }

    @GetMapping()
    public String getSchedule(Model model) {
        model.addAttribute("filmSessions", filmSessionService.findAll());
        return "schedule/list";
    }

    @GetMapping("/{id}")
    public String getBuyTicket(Model model, @PathVariable int id, HttpServletRequest request) {
        var filmSession = filmSessionService.findById(id);
        if (filmSession.isEmpty()) {
            model.addAttribute("message", "Пользователь с id " + id + " не найден");
            return "errors/404";
        }
        var hall = hallServices.findHallById(filmSession.get().getHallsId());
        var rowCount = hallServices.getRowListById(hall.get().getId());
        var placeCount = hallServices.getPlaceListById(hall.get().getId());
        var film = filmService.findById(filmSession.get().getFilmId());
        var user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("filmSession", filmSession.get());
        model.addAttribute("film", film.get());
        model.addAttribute("hall", hall.get());
        model.addAttribute("rowCount", rowCount);
        model.addAttribute("placeCount", placeCount);
        return "schedule/one";
    }
}
