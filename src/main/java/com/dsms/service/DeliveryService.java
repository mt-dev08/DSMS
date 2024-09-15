package com.dsms.service;

import com.dsms.dto.DeliveryPackageDto;

public interface DeliveryService {
    DeliveryPackageDto calculateCostAndTime(DeliveryPackageDto requestDto);
    void deliverPackage(String packageId);
}
