package com.dsms.service.serviceimpl;

import com.dsms.dto.DeliveryPackageDto;
import com.dsms.service.DeliveryService;

public class ExpressDeliveryService implements DeliveryService {
    public DeliveryPackageDto calculateCostAndTime(DeliveryPackageDto requestDto) {
        double cost = requestDto.getWeight() * 3 + requestDto.getDistance() * 1.5;
        String time = "72 hours";

        DeliveryPackageDto responseDto = new DeliveryPackageDto();
        responseDto.setPackageId(requestDto.getPackageId());
        responseDto.setCost(cost);
        responseDto.setDeliveryTime(time);

        return responseDto;
    }

    @Override
    public void deliverPackage(String packageId) {
        System.out.println("Delivering package via Express Delivery: " + packageId);
    }
}
