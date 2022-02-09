package com.example.restaurant.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "rider")
@Data
public class Rider {
    @Id
    private int id;
    private String username;
    private String notelp;

    @OneToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
