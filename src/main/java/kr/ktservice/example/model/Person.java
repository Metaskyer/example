package kr.ktservice.example.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
@Data
public class Person extends BaseEntity {

    @Column(name = "worker_name")
    @NotEmpty
    private String workerName;

    @Column(name = "worker_number")
    @NotEmpty
    private String workerNumber;

    @Column(name="worker_division")
    @NotEmpty
    private String workerDivision;
}
