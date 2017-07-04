package ua.dp.levelup.service;

import ua.dp.levelup.core.model.Order;
import ua.dp.levelup.core.model.Ticket;

import java.util.List;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public interface OrderService
{
    void createOrder(Order order);

    void createOrder(Order order, Ticket ticket);

    Order getOrderById(long orderId);

    void removeOrderById(long orderId);

    void addTicketsToOrderById(long orderId, Ticket... tickets);

    List<Order> getAllOrders();
}
