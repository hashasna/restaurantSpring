package com.example.restaurant.repository;

import com.example.restaurant.model.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PembeliRepository extends JpaRepository<Pembeli, Integer> {
}