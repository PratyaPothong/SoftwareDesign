package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final TableService tableService;

    @Autowired
    public ReservationController(ReservationService reservationService, TableService tableService) {
        this.reservationService = reservationService;
        this.tableService = tableService;
    }

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        // Add business logic for reservation creation and validation
        return reservationService.createReservation(reservation);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) throws NotFoundException {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/tables/all")
    public List<Table> getAllTables() {
        return tableService.getAllTables();
    }

    // Additional endpoints for updating and deleting reservations
    // You can implement similar methods for tables and customers as well
}
