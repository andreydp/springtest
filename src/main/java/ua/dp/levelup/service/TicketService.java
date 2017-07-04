package ua.dp.levelup.service;

import ua.dp.levelup.core.model.Ticket;

import java.util.List;

/**
 * Created by andreypo on 7/4/2017.
 */
public interface TicketService
{
    void createTicket(Ticket ticket);

    Ticket getTicketById(long ticketId);

    void removeTicketById(long ticketId);

    List<Ticket> getAllTickets();
}
