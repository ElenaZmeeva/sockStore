package com.example.sockstore.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "socks")
public class SocksEntity {
@Id
private Long id;
private String color;
private Integer cottonPart;
private Integer quantity;

}
