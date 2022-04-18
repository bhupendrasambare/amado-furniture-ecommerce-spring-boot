package com.amado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String ip;

    @ManyToOne
    @JoinColumn(name = "users_id")
    users users;

}
