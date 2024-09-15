package com.dsms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveryPackageDto {
    private Long id;
    @NotNull
    private String packageId;
    private double weight;
    private double distance;
    private String deliveryType;
    private double cost;
    private String deliveryTime;
}
