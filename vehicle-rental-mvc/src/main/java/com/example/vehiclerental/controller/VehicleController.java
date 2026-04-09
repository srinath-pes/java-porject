package com.example.vehiclerental.controller;

import com.example.vehiclerental.entity.Vehicle;
import com.example.vehiclerental.entity.VehicleStatus;
import com.example.vehiclerental.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("vehicles", vehicleService.findAll());
        return "vehicles/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        Vehicle vehicle = new Vehicle();
        vehicle.setStatus(VehicleStatus.AVAILABLE);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("statuses", VehicleStatus.values());
        return "vehicles/form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statuses", VehicleStatus.values());
            return "vehicles/form";
        }
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("vehicle", vehicleService.findById(id));
        model.addAttribute("statuses", VehicleStatus.values());
        return "vehicles/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        vehicleService.deleteById(id);
        return "redirect:/vehicles";
    }
}
