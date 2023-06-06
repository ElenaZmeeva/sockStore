package com.example.sockstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Описание сущности
 * @author Elena Zmeeva
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "socks")
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** Цвет носков */
    private String color;
    /** Количество хлопка в составе */
    private Integer cottonPart;
    /** Количество носков */
    private Integer quantity;

}
