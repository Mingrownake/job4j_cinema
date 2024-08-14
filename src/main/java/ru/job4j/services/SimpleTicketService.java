package ru.job4j.services;

import org.springframework.stereotype.Service;
import ru.job4j.models.Ticket;
import ru.job4j.repository.TicketRepository;

import java.util.Optional;

@Service
public class SimpleTicketService implements TicketServices {
    private final TicketRepository sql2oTicketRepository;

    public SimpleTicketService(TicketRepository sql2oTicketRepository) {
        this.sql2oTicketRepository = sql2oTicketRepository;
    }

    @Override
    public Optional<Ticket> save(Ticket ticket) {
        return sql2oTicketRepository.save(ticket);
    }
}
