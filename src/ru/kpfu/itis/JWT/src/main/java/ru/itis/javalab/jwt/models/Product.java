package ru.itis.javalab.jwt.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne()
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private ProductPhoto product_photo;
    @OneToOne(mappedBy = "product")
    private ProductInfo product_info;
    @ManyToMany(mappedBy = "productList")
    private List<Orders> ordersList;

}
