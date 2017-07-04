package ua.dp.levelup.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.core.model.Ticket;
import ua.dp.levelup.dao.TicketDao;

import java.util.List;

/**
 * Created by java on 27.06.2017.
 */
@Repository
@Transactional
public class TicketDaoImpl implements TicketDao {


    @Autowired
    private HibernateTemplate template;

    @Override
    public void createTicket(Ticket ticket) {
        template.save(ticket);
    }

    @Override
    public void createTicket(Ticket ticket, long orderId)
    {

    }

    @Override
    public Ticket getTicketById(long ticketId)
    {
        return null;
    }

    @Override
    public void removeTicketById(long ticketId)
    {

    }

    @Override
    public void addTicketsToOrderById(long ticketId, long orderId)
    {

    }

    @Override
    public List<Ticket> getAllTickets()
    {
        return null;
    }
}
