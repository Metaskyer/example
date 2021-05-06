package kr.ktservice.example.worker;

import kr.ktservice.example.model.Person;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.*;

@Entity
@Table(name = "workers")
public class Worker extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "worker_specialties", joinColumns = @JoinColumn(name = "worker_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Speciality> specialities;

    protected Set<Speciality> getSpecialitiesInternal() {
        if(this.specialities == null) {
            this.specialities = new HashSet<>();
        }
        return this.specialities;
    }

    protected  void setSpecialitiesInternal(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    @XmlElement
    public List<Speciality> getSpecialties() {
        List<Speciality> sortedSpecs = new ArrayList<>(getSpecialitiesInternal());
        PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedSpecs);
    }

    public int getNrOfSpecialties() {
        return getSpecialitiesInternal().size();
    }

    public void addSpecialty(Speciality speciality) {
        getSpecialitiesInternal().add(speciality);
    }
}
