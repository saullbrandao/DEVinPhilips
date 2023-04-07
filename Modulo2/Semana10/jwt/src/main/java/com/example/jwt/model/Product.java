package com.example.jwt.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name = "release_date")
    private Date releaseDate;

    private Double price;

}