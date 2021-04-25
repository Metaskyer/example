package kr.ktservice.example.customer;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String company_name;
    private String customer_name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

}