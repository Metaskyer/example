package kr.ktservice.example.worker;

import kr.ktservice.example.model.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "specialties")
public class Speciality extends NamedEntity implements Serializable {

}
