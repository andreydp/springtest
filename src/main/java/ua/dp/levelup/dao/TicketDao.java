package ua.dp.levelup.dao;

import ua.dp.levelup.core.model.Ticket;

import java.util.List;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public interface TicketDao
{
    void createTicket(Ticket ticket);

    Ticket getTicketById(long ticketId);

    void removeTicketById(long ticketId);

    List<Ticket> getAllTickets();
}
