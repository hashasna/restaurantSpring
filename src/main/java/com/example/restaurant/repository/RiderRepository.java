package com.example.restaurant.repository;

import com.example.restaurant.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Integer> {
}