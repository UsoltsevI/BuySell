package edu.phystech.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String title;
    private String description;
    private String author;
    private String city;
    private Long id;
    private int price;
}
