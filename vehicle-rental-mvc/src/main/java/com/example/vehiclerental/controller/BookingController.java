package com.example.vehiclerental.controller;

import com.example.vehiclerental.entity.Booking;
import com.example.vehiclerental.service.BookingService;
import com.example.vehiclerental.service.CustomerService;
import com.example.vehiclerental.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final VehicleService vehicleService;
    private final CustomerService customerService;

    public BookingController(BookingService bookingService, VehicleService vehicleService, CustomerService customerService) {
        this.bookingService = bookingService;
        this.vehicleService = vehicleService;
        this.customerService = customerService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("bookings", bookingService.findAll());
        return "bookings/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("vehicles", vehicleService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "bookings/form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("booking") Booking booking, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("vehicles", vehicleService.findAll());
            model.addAttribute("customers", customerService.findAll());
            return "bookings/form";
        }
        bookingService.save(booking);
        return "redirect:/bookings";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookingService.deleteById(id);
        return "redirect:/bookings";
    }
}
