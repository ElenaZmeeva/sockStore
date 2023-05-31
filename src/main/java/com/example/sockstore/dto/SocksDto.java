package com.example.sockstore.dto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


/**
 * ДТО
 */
@Data
public class SocksDto {
    private Long id;
    @NotBlank
    private String color;
    @Min(0)
    @Max(100)
    private Integer cottonPart;
    @Min(1)
    private Integer quantity;
}
