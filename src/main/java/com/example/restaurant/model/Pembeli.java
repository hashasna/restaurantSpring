package com.example.restaurant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pembeli")
@Data
public class Pembeli {
    @Id
    private Integer id;
    private String username;
    private String alamat;
    private String notelp;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    @JsonBackReference
    private Menu menu;

}
