package ua.dp.levelup.core.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "FILMS")
public class Film {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long filmId;
  private String name;
  private String description;
  private double duration;

  public Film(String name, String description, double duration) {
    this.name = name;
    this.description = description;
    this.duration = duration;
  }
}
