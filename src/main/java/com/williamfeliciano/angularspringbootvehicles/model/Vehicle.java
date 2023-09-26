package com.williamfeliciano.angularspringbootvehicles.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private int year;
}
