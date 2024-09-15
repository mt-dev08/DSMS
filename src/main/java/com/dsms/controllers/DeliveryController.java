package com.dsms.controllers;

import com.dsms.dto.DeliveryPackageDto;
import com.dsms.entity.DeliveryPackage;
import com.dsms.factory.DeliveryServiceFactory;
import com.dsms.mapper.DeliveryPackageMapper;
import com.dsms.repository.DeliveryPackageRepo;
import com.dsms.service.DeliveryService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {


    private DeliveryPackageRepo deliveryPackageRepo;

    @PostMapping("/calculate")
    public ResponseEntity<DeliveryPackageDto> calculateDelivery(@Valid @RequestBody DeliveryPackageDto requestDto) {
        // Validate if the packageId and deliveryType exist in the same record
//        Optional<DeliveryPackage> existingPackage = deliveryPackageRepo.findByPackageIdAndDeliveryType(requestDto.getPackageId(), requestDto.getDeliveryType());
//
//        if (!existingPackage.isPresent()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }

        // Use the DeliveryServiceFactory to get the appropriate delivery service
        DeliveryService deliveryService = DeliveryServiceFactory.getDeliveryService(requestDto.getDeliveryType());
        DeliveryPackageDto responseDto = deliveryService.calculateCostAndTime(requestDto);

        // Map DTO to entity using the mapper
        DeliveryPackage deliveryPackage = DeliveryPackageMapper.toEntity(requestDto);
        deliveryPackage.setCost(responseDto.getCost());
        deliveryPackage.setDeliveryTime(responseDto.getDeliveryTime());

        // Save the entity
        deliveryPackageRepo.save(deliveryPackage);

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/deliver")
    public ResponseEntity<String> deliverPackage(@RequestParam String packageId, @RequestParam String deliveryType) {
        Optional<DeliveryPackage> deliveryPackageOpt = deliveryPackageRepo.findByPackageIdAndDeliveryType(packageId, deliveryType);

        if (!deliveryPackageOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid package ID or delivery type.");
        }

        DeliveryService deliveryService = DeliveryServiceFactory.getDeliveryService(deliveryType);
        deliveryService.deliverPackage(packageId);

        return ResponseEntity.ok("Package delivered!");
    }




    @PostMapping("/optimize-delivery")
    public ResponseEntity<DeliveryPackageDto> optimizeDelivery(@Valid @RequestBody DeliveryPackageDto requestDto) {
        DeliveryService deliveryService = DeliveryServiceFactory.getOptimizedDeliveryService(
                requestDto.getWeight(), requestDto.getDistance(), requestDto.getDeliveryType());
        DeliveryPackageDto responseDto = deliveryService.calculateCostAndTime(requestDto);

        return ResponseEntity.ok(responseDto);
    }
}