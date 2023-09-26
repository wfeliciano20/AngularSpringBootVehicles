package com.williamfeliciano.angularspringbootvehicles.repository;

import com.williamfeliciano.angularspringbootvehicles.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
