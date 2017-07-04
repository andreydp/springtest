package ua.dp.levelup.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOVIE_SESSION_ORDERS")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long orderId;
  @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
  private List<Ticket> tickets = new ArrayList<>();
  private double totalPrice;
  private Long clientId;

  public Order(double totalPrice, Long clientId) {
    this.totalPrice = totalPrice;
    this.clientId = clientId;
  }

  public void addTicket(Ticket t) {
    tickets.add(t);
  }

  public void addTickets(List<? extends Ticket> ticketsList)
  {
    tickets.addAll(ticketsList);
  }
}
