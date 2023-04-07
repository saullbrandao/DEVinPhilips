package com.example.jwt.controllers.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class ProductDTO {
    private String name;
    private String description;
    private Date releaseDate;
    private Double price;
}
