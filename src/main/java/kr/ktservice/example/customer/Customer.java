package kr.ktservice.example.customer;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "customer_name")
    @NotEmpty
    private String customer_name;

    private String address;

    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 11)
    private String telephone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
//    private Set<Product> products;

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
//
//    protected Set<Product> getProductsInternal() {
//        if(this.products == null) {
//            this.products = new HashSet<>();
//        }
//        return this.products;
//    }

}