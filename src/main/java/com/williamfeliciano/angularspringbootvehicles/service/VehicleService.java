package com.williamfeliciano.angularspringbootvehicles.service;

import com.williamfeliciano.angularspringbootvehicles.dto.VehicleDto;
import com.williamfeliciano.angularspringbootvehicles.exceptions.AppException;
import com.williamfeliciano.angularspringbootvehicles.mapper.VehicleMapper;
import com.williamfeliciano.angularspringbootvehicles.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public List<VehicleDto> getAllVehicles() {
        return vehicleMapper.toVehicleDtos(vehicleRepository.findAll());
    }

    public VehicleDto getVehicleById(Long id) {
        return vehicleMapper.toVehicleDto(
                vehicleRepository
                        .findById(id)
                        .orElseThrow(
                                () ->
                                        new AppException("Vehicle with id: " + id + " not found", HttpStatus.NOT_FOUND)));
    }


    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        var vehicleToSave = vehicleMapper.toVehicle(vehicleDto);

        var savedVehicle = vehicleRepository.save(vehicleToSave);

        return vehicleMapper.toVehicleDto(savedVehicle);
    }
}
