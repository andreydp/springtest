package ua.dp.levelup.service.impl;

import ua.dp.levelup.core.model.Ticket;
import ua.dp.levelup.dao.TicketDao;
import ua.dp.levelup.service.TicketService;

import java.util.List;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public class TicketServiceImpl implements TicketService
{

  private TicketDao ticketDao;

  public void setTicketDao(final TicketDao TicketDao) {
    this.ticketDao = ticketDao;
  }

    @Override
    public void createTicket(Ticket ticket)
    {
        ticketDao.createTicket(ticket);
    }

    @Override
    public Ticket getTicketById(long ticketId)
    {
        return ticketDao.getTicketById(ticketId);
    }

    @Override
    public void removeTicketById(long ticketId)
    {
        ticketDao.removeTicketById(ticketId);
    }

    @Override
    public List<Ticket> getAllTickets()
    {
        return  ticketDao.getAllTickets();
    }
}
