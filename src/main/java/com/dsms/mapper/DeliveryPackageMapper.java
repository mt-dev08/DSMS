//package com.dsms.mapper;
//
//import com.dsms.dto.DeliveryPackageDto;
//import com.dsms.entity.DeliveryPackage;
//import org.modelmapper.ModelMapper;
//
//public class DeliveryPackageResponse {
//    private static final ModelMapper modelMapper = new ModelMapper();
//
//    public static DeliveryPackageDto mapToDeliveryPackageDto(DeliveryPackage deliveryPackage) {
//        return modelMapper.map(deliveryPackage, DeliveryPackageDto.class);
//    }
//
//    public static DeliveryPackage mapToDeliveryPackage(DeliveryPackageDto deliveryPackageDto) {
//        DeliveryPackage deliveryPackage = modelMapper.map(deliveryPackageDto, DeliveryPackage.class);
//        return deliveryPackage;
//    }
//}

package com.dsms.mapper;

import com.dsms.dto.DeliveryPackageDto;
import com.dsms.entity.DeliveryPackage;
import org.modelmapper.ModelMapper;

public class DeliveryPackageMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static DeliveryPackageDto toDto(DeliveryPackage deliveryPackage) {
        try {
            return modelMapper.map(deliveryPackage, DeliveryPackageDto.class);
        } catch (Exception e) {
            // Handle mapping exception (e.g., log the error)
            throw new RuntimeException("Error mapping DeliveryPackage to DTO", e);
        }
    }

    public static DeliveryPackage toEntity(DeliveryPackageDto deliveryPackageDto) {
        try {
            return modelMapper.map(deliveryPackageDto, DeliveryPackage.class);
        } catch (Exception e) {
            // Handle mapping exception (e.g., log the error)
            throw new RuntimeException("Error mapping DeliveryPackageDto to entity", e);
        }
    }
}