package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import ru.job4j.models.Ticket;

import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class Sql2oTicketRepository implements TicketRepository {
    private final Sql2o sql2o;
    private final Logger logger = Logger.getLogger(Sql2oTicketRepository.class.getName());

    public Sql2oTicketRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Ticket> save(Ticket ticket) {
        try (Connection con = sql2o.open()) {
            String sql = "insert into tickets (session_id, row_number, place_number, user_id) values "
                    + "(:sessionId, :rowNumber, :placeNumber, :userId)";
            var query = con.createQuery(sql, true)
                    .addParameter("sessionId", ticket.getSessionId())
                    .addParameter("rowNumber", ticket.getRowNumber())
                    .addParameter("placeNumber", ticket.getPlaceNumber())
                    .addParameter("userId", ticket.getUserId());
            Integer generatedKey = query.executeUpdate().getKey(Integer.class);
            ticket.setId(generatedKey);
            return Optional.of(ticket);
        } catch (Sql2oException exception) {
            logger.info("Билет на данное место уже куплен. Попробуйте купить новый билет.");
        }
        return Optional.empty();
    }
}
