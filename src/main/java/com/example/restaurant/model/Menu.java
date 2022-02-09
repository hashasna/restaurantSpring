package com.example.restaurant.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "menu")
@Data
@NoArgsConstructor
public class Menu {
    @Id
    private int id;
    private String makanan;
    private String minuman;
    private int harga;

    @OneToMany(mappedBy = "menu")
    private List<Pembeli> pembeli;

    public Menu(int idMenu){
        this.id = id;
    }

}
