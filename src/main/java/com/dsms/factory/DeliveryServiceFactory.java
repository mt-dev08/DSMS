package com.dsms.factory;

import com.dsms.service.DeliveryService;
import com.dsms.service.serviceimpl.*;

public class DeliveryServiceFactory {
    public static DeliveryService getDeliveryService(String deliveryType) {
        switch (deliveryType) {
            case "Standard":
                return new StandardDeliveryService();
            case "Express":
                return new ExpressDeliveryService();
            case "SameDay":
                return new SameDayDeliveryService();
            default:
                throw new IllegalArgumentException("Invalid delivery type");
        }
    }



    public static DeliveryService getOptimizedDeliveryService(double weight, double distance, String urgency) {
        // Add logic to choose the best service based on the criteria
        if (distance < 100) {
            return new SameDayDeliveryService();
        } else if (weight > 10) {
            return new ExpressDeliveryService();
        } else {
            return new StandardDeliveryService();
        }
    }
}
