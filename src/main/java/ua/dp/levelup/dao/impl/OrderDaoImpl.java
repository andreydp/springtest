package ua.dp.levelup.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.core.model.Order;
import ua.dp.levelup.core.model.Ticket;
import ua.dp.levelup.dao.OrderDao;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
@Repository
@Transactional
public class OrderDaoImpl implements OrderDao
{
    private Session session;

    @Autowired
    private HibernateTemplate template;

    @Override
    public void createOrder(Order order)
    {
        template.save(order);
    }

    @Override
    public void createOrder(Order order, Ticket ticket)
    {
        session = template.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        template.save(ticket);
        template.save(order);

        transaction.commit();
    }

    @Override
    public Order getOrderById(long orderId)
    {
        session = template.getSessionFactory().openSession();
        Order order = template.get(Order.class, orderId);
        if (null != order)
        {
            return order;
        } else
            throw new RuntimeException("There is no such order! OrderId: " + orderId);
    }

    @Override
    public void removeOrderById(long orderId)
    {
        session = template.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Order order = template.get(Order.class, orderId);
        if (null != order)
        {
            List<Ticket> ticketsToDelete = order.getTickets();
            template.deleteAll(ticketsToDelete);
            template.delete(order);
        } else
            throw new RuntimeException("There is no such order! OrderId: " + orderId);
        transaction.commit();
    }

    @Override
    public void addTicketsToOrderById(long orderId, Ticket... tickets)
    {
        session = template.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Order order = template.load(Order.class, orderId);
        if (null != order)
        {
            order.addTickets(Arrays.asList(tickets));
            transaction.commit();
        } else
            throw new RuntimeException("There is no such order! OrderId: " + orderId);
    }

    @Override
    public List<Order> getAllOrders()
    {
        session = template.getSessionFactory().openSession();
        return template.loadAll(Order.class);
    }
}
