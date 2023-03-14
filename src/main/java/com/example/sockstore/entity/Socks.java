package com.example.sockstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "socks")
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    private Integer cottonPart;
    private Integer quantity;

}
