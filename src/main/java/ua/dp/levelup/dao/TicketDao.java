package ua.dp.levelup.dao;

import ua.dp.levelup.core.model.Ticket;

import java.util.List;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public interface TicketDao
{
    void createTicket(Ticket ticket);

    void createTicket(Ticket ticket, long orderId);

    Ticket getTicketById(long ticketId);

    void removeTicketById(long ticketId);

    void addTicketsToOrderById(long ticketId, long orderId);

    List<Ticket> getAllTickets();
}
