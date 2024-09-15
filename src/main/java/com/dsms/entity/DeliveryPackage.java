package com.dsms.entity;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "delivery_pkg",uniqueConstraints = @UniqueConstraint(columnNames = "packageId"))
public class DeliveryPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String packageId;
    private double weight;
    private double distance;
    private String deliveryType;
    private double cost;
    private String deliveryTime;

    // Getters and setters
}
