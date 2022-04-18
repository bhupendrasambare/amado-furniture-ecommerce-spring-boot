package com.amado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @NotNull
    String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    product product;
}
