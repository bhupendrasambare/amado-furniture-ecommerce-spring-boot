package com.amado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
}
