package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantTableService { // Updated to RestaurantTableService

    private final TableRepository restaurantTableRepository; // Updated to RestaurantTableRepository

    @Autowired
    public RestaurantTableService(TableRepository restaurantTableRepository) { // Updated to RestaurantTableRepository
        this.restaurantTableRepository = restaurantTableRepository;
    }

    public List<RestaurantTable> getAllTables() { // Updated to RestaurantTable
        return restaurantTableRepository.findAll();
    }

    public RestaurantTable getTableById(Integer id) {
        Optional<RestaurantTable> table = restaurantTableRepository.findById(id);
        return table.orElse(null);
    }

    public RestaurantTable createTable(RestaurantTable table) { // Updated to RestaurantTable
        return restaurantTableRepository.save(table);
    }

    public void deleteTable(Integer id) {
        restaurantTableRepository.deleteById(id);
    }
}
