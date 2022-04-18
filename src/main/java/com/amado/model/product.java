package com.amado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int views;
    int quantity;


    @NotNull
    double price;

    @NotNull
    String name;

    @NotNull
    String discription;

    @NotNull
    String date;

    @ManyToOne
    @JoinColumn(name = "categories")
    categories categories;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private brand brand;

    @NotNull
    String image;

}
