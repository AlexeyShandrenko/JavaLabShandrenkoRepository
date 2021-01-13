package ru.itis.javalab.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Product {
    private Long id;
    private String title;
    private Double price;
    private User owner;
}
