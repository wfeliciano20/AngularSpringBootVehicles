package com.williamfeliciano.angularspringbootvehicles.controller;

import com.williamfeliciano.angularspringbootvehicles.dto.VehicleDto;
import com.williamfeliciano.angularspringbootvehicles.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehicleController{
    private final VehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> GetAllVehicles(){
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> GetVehicleById(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<VehicleDto> CreateVehicle(@Valid @RequestBody VehicleDto vehicleDto){
        VehicleDto createdVehicle = vehicleService.createVehicle(vehicleDto);
        return ResponseEntity.created(URI.create("/vehicles/" + vehicleDto.getId())).body(createdVehicle);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> DeleteVehicle(@PathVariable Long id){
        return  ResponseEntity.ok(vehicleService.deleteVehicle(id));
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> UpdateVehicle(@PathVariable Long id, @Valid @RequestBody VehicleDto vehicleDto){
        return ResponseEntity.ok(vehicleService.updateVehicle(id,vehicleDto));
    }


}
