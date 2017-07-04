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

  void createOrder(Order order){
      orderDao.createOrder(order);
  }

  void createOrder(Order order, Ticket ticket){
      orderDao.createOrder(order, ticket);
  }

  Order getOrderById(long orderId){
      return orderDao.getOrderById(orderId);
  }

  void removeOrderById(long orderId){
      orderDao.removeOrderById(orderId);
  }

  void addTicketsToOrderById(long orderId, Ticket... tickets){
      orderDao.addTicketsToOrderById(orderId, tickets);
  }

  List<Order> getAllOrders(){
      return orderDao.getAllOrders();
  }
}
