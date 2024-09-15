package com.dsms.repository;


import com.dsms.entity.DeliveryPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryPackageRepo extends JpaRepository<DeliveryPackage, Long> {
//    Optional<DeliveryPackage> findByPackageId(String packageId);
    Optional<DeliveryPackage> findByPackageIdAndDeliveryType(String packageId, String deliveryType);
}
