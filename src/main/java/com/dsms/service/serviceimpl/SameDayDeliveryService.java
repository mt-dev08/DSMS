package com.dsms.service.serviceimpl;

import com.dsms.dto.DeliveryPackageDto;
import com.dsms.service.DeliveryService;

public class SameDayDeliveryService implements DeliveryService {
    public DeliveryPackageDto calculateCostAndTime(DeliveryPackageDto requestDto) {
        double cost = requestDto.getWeight() * 5 + requestDto.getDistance() * 2;
        String time = "24 hours";

        DeliveryPackageDto responseDto = new DeliveryPackageDto();
        responseDto.setPackageId(requestDto.getPackageId());
        responseDto.setCost(cost);
        responseDto.setDeliveryTime(time);

        return responseDto;
    }

    @Override
    public void deliverPackage(String packageId) {
        System.out.println("Delivering package via Same Day Delivery: " + packageId);
    }
}
