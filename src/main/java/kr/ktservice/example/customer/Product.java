package kr.ktservice.example.customer;

import kr.ktservice.example.model.NamedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    private int qty;
    private double price;
    private double amount;
    private String address1;
    private String address2;



}
