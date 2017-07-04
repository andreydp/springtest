package ua.dp.levelup.entity;

import lombok.*;

/**
 * Created by andrey on 15.06.17.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    private double maxSpeed;
    String model;
    Color color;

}
