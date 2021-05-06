package kr.ktservice.example.customer;


import kr.ktservice.example.model.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="types")
public class ProductType extends NamedEntity {

}
