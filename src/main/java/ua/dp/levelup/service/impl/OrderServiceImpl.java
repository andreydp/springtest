package ua.dp.levelup.service.impl;

import ua.dp.levelup.core.model.Order;
import ua.dp.levelup.core.model.Ticket;
import ua.dp.levelup.dao.OrderDao;
import ua.dp.levelup.service.OrderService;

import java.util.List;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public class OrderServiceImpl implements OrderService {

  private OrderDao orderDao;

  public void setOrderDao(final OrderDao orderDao) {
    this.orderDao = orderDao;
  }

  public void createOrder(Order order){
      orderDao.createOrder(order);
  }

  public void createOrder(Order order, Ticket ticket){
      orderDao.createOrder(order, ticket);
  }

  public Order getOrderById(long orderId){
      return orderDao.getOrderById(orderId);
  }

  public void removeOrderById(long orderId){
      orderDao.removeOrderById(orderId);
  }

  public void addTicketsToOrderById(long orderId, Ticket... tickets){
      orderDao.addTicketsToOrderById(orderId, tickets);
  }

  public List<Order> getAllOrders(){
      return orderDao.getAllOrders();
  }
}
