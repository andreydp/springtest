package ua.dp.levelup.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
public class TicketDaoImpl implements TicketDao
{

    private Session session;

    @Autowired
    private HibernateTemplate template;

    @Override
    public void createTicket(Ticket ticket)
    {
        template.save(ticket);
    }

    @Override
    public Ticket getTicketById(long ticketId)
    {
        session = template.getSessionFactory().openSession();
        Ticket ticket = template.get(Ticket.class, ticketId);
        if (null != ticket)
        {
            return ticket;
        } else
            throw new RuntimeException("There is no such ticket! ticketId: " + ticketId);
    }

    @Override
    public void removeTicketById(long ticketId)
    {
        session = template.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = template.get(Ticket.class, ticketId);
        if (null != ticket)
        {
            template.delete(ticket);
        } else
            throw new RuntimeException("There is no such ticket! TicketId: " + ticketId);
        transaction.commit();
    }

    @Override
    public List<Ticket> getAllTickets()
    {
        session = template.getSessionFactory().openSession();
        return template.loadAll(Ticket.class);
    }
}
