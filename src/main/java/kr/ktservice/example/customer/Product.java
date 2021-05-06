package kr.ktservice.example.customer;

import kr.ktservice.example.model.NamedEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Product extends NamedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String product_name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductType type_id;

}
