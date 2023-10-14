package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final RestaurantTableService restaurantTableService;

    @Autowired
    public ReservationController(ReservationService reservationService, RestaurantTableService restaurantTableService) {
        this.reservationService = reservationService;
        this.restaurantTableService = restaurantTableService;
    }

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        try {
            // Add business logic for reservation creation and validation
            return reservationService.createReservation(reservation);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid reservation data", e);
        }
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Integer id) throws NotFoundException {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/tables/all")
    public List<RestaurantTable> getAllTables() {
        return restaurantTableService.getAllTables();
    }

    // Additional endpoints for updating and deleting reservations
    // You can implement similar methods for tables and customers as well
}
