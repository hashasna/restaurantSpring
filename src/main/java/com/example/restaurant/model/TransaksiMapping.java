package com.example.restaurant.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SqlResultSetMapping(name = "cobaNative", entities = {
        @EntityResult(entityClass = TransaksiMapping.class, fields = {
                @FieldResult(name = "id", column = "id"),
                @FieldResult(name = "namaPembeli", column = "username"),
                @FieldResult(name = "makanan", column = "makanan"),
                @FieldResult(name = "minuman", column = "minuman"),
                @FieldResult(name = "rider", column = "username"),
        })
})

public class TransaksiMapping {
    @Id
    private String id;
    private String namaPembeli;
    private String makanan;
    private String minuman;
    private String rider;

}
