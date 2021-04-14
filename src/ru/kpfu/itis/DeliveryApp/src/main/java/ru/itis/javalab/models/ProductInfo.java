package ru.itis.javalab.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product_info")
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    private String description;
    private String consist;
    private String shelf_life_and_storage_conditions;
    @ManyToOne()
    @JoinColumn(name = "producer_id")
    private Producer producer;
    private String fats;
    private String proteins;
    private String carbohydrates;

}
