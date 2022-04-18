package com.amado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int quantity;

    @ManyToOne
    @JoinColumn(name = "users_id")
    users users;

    @ManyToOne
    @JoinColumn(name = "product_id")
    product product;

}
