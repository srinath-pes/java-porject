package com.example.vehiclerental.service;

import com.example.vehiclerental.entity.Vehicle;
import com.example.vehiclerental.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAll() { return vehicleRepository.findAll(); }
    public Vehicle save(Vehicle vehicle) { return vehicleRepository.save(vehicle); }
    public Vehicle findById(Long id) { return vehicleRepository.findById(id).orElseThrow(); }
    public void deleteById(Long id) { vehicleRepository.deleteById(id); }
}
