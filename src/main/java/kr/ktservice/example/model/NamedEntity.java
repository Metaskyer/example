package kr.ktservice.example.model;

import javax.persistence.Column;

public class NamedEntity extends BaseEntity{

    @Column(name = "customer_name")
    private String customer_name;
}
