package com.example.restaurant.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuDto {
    private int id;
    private String makanan;
    private String minuman;
    private int harga;
}
