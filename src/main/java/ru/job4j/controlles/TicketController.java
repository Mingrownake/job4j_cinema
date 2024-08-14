package ru.job4j.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.models.Ticket;
import ru.job4j.services.TicketServices;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    private final TicketServices ticketServices;

    public TicketController(TicketServices ticketServices) {
        this.ticketServices = ticketServices;
    }

    @PostMapping("/buy")
    public String postByuTicket(@ModelAttribute Ticket ticket, Model model) {
        var optionalTicket = ticketServices.save(ticket);
        if (optionalTicket.isEmpty()) {
            model.addAttribute("message", "Ошибка при покупке билета. Данное место уже занято, "
                    + "попробуйте купить новый билет.");
            return "errors/404";
        }
        model.addAttribute("ticket", optionalTicket.get());
        return "successfully/correct";
    }
}
